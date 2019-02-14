package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.receiver.Receiver;
import com.jvmless.mrsandwich.receiver.ReceiverRepository;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.MessageNotFoundException;
import com.jvmless.mrsandwich.message.MessageRepository;
import com.jvmless.mrsandwich.notification.commands.NotifyClients;
import lombok.NonNull;

import java.util.stream.Stream;

public class NotifyClientsHandler {

    private NotificationRepository notificationRepository;
    private MessageRepository messageRepository;
    private ReceiverRepository receiverRepository;
    private NotificationSenderRepository notificationSenderRepository;
    private NotificationSenderPort notificationSenderPort;

    public NotifyClientsHandler(NotificationRepository notificationRepository, MessageRepository messageRepository, ReceiverRepository receiverRepository, NotificationSenderRepository notificationSenderRepository, NotificationSenderPort notificationSenderPort) {
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
        Message message = messageRepository.findBy(notifyClients.getMessageId());
        if (message == null) {
            throw new MessageNotFoundException("Cannot find message with id: " + notifyClients.getMessageId());
        }
        Stream<Receiver> clients = receiverRepository.findByTargetArea(notifyClients.getTargetArea());
        NotificationId newId = notifyClients.getNotificationId();
        Vendor vendor = notificationSenderRepository.findBy(notifyClients.getVendorId());
        clients.forEach(client -> {
                Notification notification = new Notification(
                        newId,
                        client,
                        vendor,
                        message,
                        NotificationStatus.ENABLED
                );
//                pushNotificationAdapter.send(client.getFcmRegistrationId(), message.getMessageBody());
                notificationRepository.save(notification);
        });

    }
}
