package com.jvmless.mrsandwich.notification;

public interface NotificationSenderRepository {
    NotificationSender save(NotificationSender notificationSender);
    NotificationSender findBy(NotificationSenderId notificationSenderId);
}
