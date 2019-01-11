package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.NotificationId;

public interface NotificationRepository {
    Notification save(Notification notification);
    Notification findBy(NotificationId notificationId);
}
