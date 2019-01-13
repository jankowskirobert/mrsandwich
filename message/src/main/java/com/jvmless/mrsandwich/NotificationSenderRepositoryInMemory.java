package com.jvmless.mrsandwich;

import com.jvmless.mrsandwich.message.NotificationSender;
import com.jvmless.mrsandwich.message.NotificationSenderId;
import com.jvmless.mrsandwich.message.NotificationSenderRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationSenderRepositoryInMemory implements NotificationSenderRepository {

    private Map<NotificationSenderId, NotificationSender> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public NotificationSender save(NotificationSender notificationSender) {
        return inMemoryRepository.put(notificationSender.getNotificationSenderId(), notificationSender);
    }

    @Override
    public NotificationSender findBy(NotificationSenderId notificationSenderId) {
        return inMemoryRepository.get(notificationSenderId);
    }
}
