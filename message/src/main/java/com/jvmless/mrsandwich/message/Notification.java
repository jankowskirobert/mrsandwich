package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.client.Client;
import lombok.Data;

@Data
public class Notification {
    private NotificationId notificationId;
    private Client client;
    private TargetArea target;
    private NotificationSender notificationSender;
    private Message message;
    private NotificationStatus status;

    public static Notification of(
            NotificationId notificationId,
            Client client,
            TargetArea targetArea,
            NotificationSender notificationSender,
            MessageId messageId
    ){
        return null;
    }

    public Notification(NotificationId notificationId, Client client, TargetArea target, NotificationSender notificationSender, Message message, NotificationStatus status) {
        this.notificationId = notificationId;
        this.client = client;
        this.target = target;
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
