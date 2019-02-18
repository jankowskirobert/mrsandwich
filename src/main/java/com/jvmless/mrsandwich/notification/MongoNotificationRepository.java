package com.jvmless.mrsandwich.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoNotificationRepository extends MongoRepository<Notification, NotificationId> {
}
