package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.client.Client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationRepositoryInMemoryAdapter implements NotificationRepository {

    private Map<NotificationId, Notification> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Notification save(Notification notification) {
        return inMemoryRepository.put(notification.getNotificationId(), notification);
    }

    @Override
    public Notification findBy(NotificationId notificationId) {
        return inMemoryRepository.get(notificationId);
    }
}
