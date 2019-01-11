package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.message.commands.NotifyClients;
import lombok.NonNull;

public class NotifyClientsHandler {

    NotificationRepository notificationRepository;

    public NotifyClientsHandler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void handle(@NonNull NotifyClients notifyClients) {
        Notification notification = notificationRepository.findBy(notifyClients.getNotificationId());
        if(notification != null) {
            throw new NotificationAlreadyExistException("ID already in database");
        }
    }
}
