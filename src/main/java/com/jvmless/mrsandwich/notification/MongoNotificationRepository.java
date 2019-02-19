package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.notification.Notification;
import com.jvmless.mrsandwich.notification.NotificationId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoNotificationRepository extends MongoRepository<Notification, NotificationId> {
}
