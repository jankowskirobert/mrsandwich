package com.jvmless.mrsandwich.message;

public interface NotificationSenderRepository {
    NotificationSender save(NotificationSender notificationSender);
    NotificationSender findBy(NotificationSenderId notificationSenderId);
}
