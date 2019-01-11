package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.message.notification.commands.NotifyClients;
import lombok.NonNull;

public class NotifyClientsHandler {

    NotificationRepository notificationRepository;
    MessageRepository messageRepository;

    public NotifyClientsHandler(NotificationRepository notificationRepository, MessageRepository messageRepository) {
        this.notificationRepository = notificationRepository;
        this.messageRepository = messageRepository;
    }

    public void handle(@NonNull NotifyClients notifyClients) {
        Notification notification = notificationRepository.findBy(notifyClients.getNotificationId());
        if(notification != null) {
            throw new NotificationAlreadyExistException("Id already in database");
        }
        Message message = messageRepository.findBy(notifyClients.getMessageId());
        if(message == null) {
            throw new MessageNotFoundException("Cannot find message with id: "+notifyClients.getMessageId());
        }
    }
}
