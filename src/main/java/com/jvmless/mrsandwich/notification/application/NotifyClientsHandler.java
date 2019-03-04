package com.jvmless.mrsandwich.notification.application;

import com.jvmless.mrsandwich.notification.*;
import com.jvmless.mrsandwich.notification.NotificationException;
import com.jvmless.mrsandwich.notification.Recipient;
import com.jvmless.mrsandwich.receiver.Receiver;
import com.jvmless.mrsandwich.receiver.ReceiverRepository;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.MessageNotFoundException;
import com.jvmless.mrsandwich.message.MessageRepository;
import com.jvmless.mrsandwich.subscription.SubscriberRepository;
import com.jvmless.mrsandwich.subscription.SubscriptionRepository;
import lombok.NonNull;

import java.util.Optional;
import java.util.stream.Stream;

public class NotifyClientsHandler {

    private NotificationRepository notificationRepository;
    private MessageRepository messageRepository;
    private ReceiverRepository receiverRepository;
    private NotificationSenderRepository notificationSenderRepository;
    private NotificationSenderPort notificationSenderPort;
    private SubscriptionRepository subscriptionRepository;
    private SubscriberRepository subscriberRepository;

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

    public void handle(@NonNull NotifyClients notifyClients) throws RuntimeException {
        Optional<Notification> old = notificationRepository.findBy(notifyClients.getNotificationId());
        old.ifPresent(x -> {
            throw new NotificationAlreadyExistException("Id already in database");
        });

        Optional<Message> message = messageRepository.findBy(notifyClients.getMessageId());

        if (!message.isPresent()) {
            throw new MessageNotFoundException("Cannot find message with id: " + notifyClients.getMessageId());
        } else {
            MessageDetails messageDetails = new MessageDetails(message.get().getMessageBody());
            //wrong = download all clients that are subscribe vendor id
            Stream<Receiver> clients = receiverRepository.findByTargetArea(notifyClients.getTargetArea());
            if (clients.count() <= 0) {
                throw new NotificationException("Selected target contains 0 active clients");
            }
            NotificationId newId = notifyClients.getNotificationId();
            Vendor vendor = notificationSenderRepository.findBy(notifyClients.getVendorId());
            Notification notification = new Notification(
                    newId,
                    vendor,
                    messageDetails
            );
            clients.forEach(client -> {
                notificationSenderPort.send(client.getFcmRegistrationId(), messageDetails.getMessageBody());
                notification.addReceiver(new Recipient(client.getId(), client.getFcmRegistrationId()));
                notification.delivered();
                notificationRepository.save(notification);
            });
        }


    }
}
