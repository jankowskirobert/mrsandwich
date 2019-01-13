package com.jvmless.mrsandwich.notification;

public interface NotificationRepository {
    Notification save(Notification notification);
    Notification findBy(NotificationId notificationId);
}
