package com.jvmless.mrsandwich.notification.application;

import com.jvmless.mrsandwich.notification.*;
import com.jvmless.mrsandwich.receiver.Receiver;
import com.jvmless.mrsandwich.receiver.ReceiverRepository;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.MessageNotFoundException;
import com.jvmless.mrsandwich.message.MessageRepository;
import com.jvmless.mrsandwich.notification.application.NotifyClients;
import lombok.NonNull;

import java.util.stream.Stream;

public class NotifyClientsHandler {

    private NotificationRepository notificationRepository;
    private MessageRepository messageRepository;
    private ReceiverRepository receiverRepository;
    private NotificationSenderRepository notificationSenderRepository;
    private NotificationSenderPort notificationSenderPort;

    public NotifyClientsHandler(NotificationRepository notificationRepository,
                                MessageRepository messageRepository,
                                ReceiverRepository receiverRepository,
                                NotificationSenderRepository notificationSenderRepository,
                                NotificationSenderPort notificationSenderPort
    ) {
        this.notificationRepository = notificationRepository;
        this.messageRepository = messageRepository;
        this.receiverRepository = receiverRepository;
        this.notificationSenderRepository = notificationSenderRepository;
        this.notificationSenderPort = notificationSenderPort;
    }

    public void handle(@NonNull NotifyClients notifyClients) {
        Notification old = notificationRepository.findBy(notifyClients.getNotificationId());
        if (old != null) {
            throw new NotificationAlreadyExistException("Id already in database");
        }
        Message messageBody = messageRepository.findBy(notifyClients.getMessageId());

        if (messageBody == null) {
            throw new MessageNotFoundException("Cannot find message with id: " + notifyClients.getMessageId());
        } else {
            MessageDetails message = new MessageDetails(messageBody.getMessageBody());
            Stream<Receiver> clients = receiverRepository.findByTargetArea(notifyClients.getTargetArea());
            NotificationId newId = notifyClients.getNotificationId();
            Vendor vendor = notificationSenderRepository.findBy(notifyClients.getVendorId());
            Notification notification = new Notification(
                    newId,
                    vendor,
                    message
            );
            clients.forEach(client -> {
                notificationSenderPort.send(client.getFcmRegistrationId(), message.getMessageBody());
                notification.addReceiver(new Recipient(client.getClientId(), client.getFcmRegistrationId()));
                notification.delivered();
                notificationRepository.save(notification);
            });
        }


    }
}
