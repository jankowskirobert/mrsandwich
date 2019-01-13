package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.MessageNotFoundException;
import com.jvmless.mrsandwich.message.MessageRepository;
import com.jvmless.mrsandwich.notification.commands.NotifyClients;
import lombok.NonNull;

import java.util.stream.Stream;

public class NotifyClientsHandler {

    private NotificationRepository notificationRepository;
    private MessageRepository messageRepository;
    private ClientRepository clientRepository;
    private NotificationSenderRepository notificationSenderRepository;
    private PushNotificationAdapter pushNotificationAdapter;

    public NotifyClientsHandler(NotificationRepository notificationRepository, MessageRepository messageRepository, ClientRepository clientRepository, NotificationSenderRepository notificationSenderRepository, PushNotificationAdapter pushNotificationAdapter) {
        this.notificationRepository = notificationRepository;
        this.messageRepository = messageRepository;
        this.clientRepository = clientRepository;
        this.notificationSenderRepository = notificationSenderRepository;
        this.pushNotificationAdapter = pushNotificationAdapter;
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
        Stream<Client> clients = clientRepository.findByTargetArea(notifyClients.getTargetArea());
        NotificationId newId = notifyClients.getNotificationId();
        NotificationSender notificationSender = notificationSenderRepository.findBy(notifyClients.getNotificationSenderId());
        clients.forEach(client -> {
                Notification notification = new Notification(
                        newId,
                        client,
                        notificationSender,
                        message,
                        NotificationStatus.ENABLED
                );
                pushNotificationAdapter.send(client.getFcmRegistrationId(), message.getMessageBody());
                notificationRepository.save(notification);
        });

    }
}
