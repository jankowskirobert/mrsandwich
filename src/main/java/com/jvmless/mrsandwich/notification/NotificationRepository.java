package com.jvmless.mrsandwich.notification;

import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification notification);
    Optional<Notification> findBy(NotificationId notificationId);
}
