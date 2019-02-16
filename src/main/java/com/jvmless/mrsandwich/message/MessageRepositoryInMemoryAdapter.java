package com.jvmless.mrsandwich.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageRepositoryInMemoryAdapter implements MessageRepository {
    private Map<MessageId, Message> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Message findBy(MessageId messageId) {
        return inMemoryRepository.get(messageId);
    }

    @Override
    public Message save(Message message) {
        return inMemoryRepository.put(message.getMessageId(), message);
    }
}
