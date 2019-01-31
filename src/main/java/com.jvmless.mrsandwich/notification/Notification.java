package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.receiver.Receiver;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.Data;

@Data
public class Notification {
    private NotificationId notificationId;
    private Receiver receiver;
    private TargetId target;
    private NotificationSender notificationSender;
    private Message message;
    private NotificationStatus status;


    public Notification(NotificationId notificationId, Receiver receiver, NotificationSender notificationSender, Message message, NotificationStatus status) {
        this.notificationId = notificationId;
        this.receiver = receiver;
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
