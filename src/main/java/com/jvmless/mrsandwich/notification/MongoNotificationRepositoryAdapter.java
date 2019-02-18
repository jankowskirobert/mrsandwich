package com.jvmless.mrsandwich.notification;

import java.util.Optional;

public class MongoNotificationRepositoryAdapter implements NotificationRepository {

    private final MongoNotificationRepository mongoNotificationRepository;

    public MongoNotificationRepositoryAdapter(MongoNotificationRepository mongoNotificationRepository) {
        this.mongoNotificationRepository = mongoNotificationRepository;
    }

    @Override
    public Notification save(Notification notification) {
        return mongoNotificationRepository.save(notification);
    }

    @Override
    public Optional<Notification> findBy(NotificationId notificationId) {
        return mongoNotificationRepository.findById(notificationId);
    }
}
