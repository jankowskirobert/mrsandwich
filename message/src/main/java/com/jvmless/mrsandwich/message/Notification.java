package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.client.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Notification {
    private NotificationId notificationId;
    private Client client;
    private TargetId target;
    private NotificationSender notificationSender;
    private Message message;
    private NotificationStatus status;


    public Notification(NotificationId notificationId, Client client, NotificationSender notificationSender, Message message, NotificationStatus status) {
        this.notificationId = notificationId;
        this.client = client;
        isMessageAndSenderMatch(notificationSender, message);
        this.status = status;
    }

    private void isMessageAndSenderMatch(NotificationSender notificationSender, Message message) {
        if(notificationSender.getNotificationSenderId().equals(message.getOwner())) {
            this.notificationSender = notificationSender;
            this.message = message;
        } else {
            throw new IllegalStateException("Notification sender doesn't match message owner");
        }
    }
}
