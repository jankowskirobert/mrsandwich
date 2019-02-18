package com.jvmless.mrsandwich.notification;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationRepositoryInMemoryAdapter implements NotificationRepository {

    private Map<NotificationId, Notification> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Notification save(Notification notification) {
        return inMemoryRepository.put(notification.getNotificationId(), notification);
    }

    @Override
    public Optional<Notification> findBy(NotificationId notificationId) {
        return Optional.ofNullable(inMemoryRepository.get(notificationId));
    }
}
