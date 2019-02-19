package com.jvmless.mrsandwich.message;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MessageRepositoryInMemoryAdapter implements MessageRepository {
    private Map<MessageId, Message> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Optional<Message> findBy(MessageId messageId) {
        return Optional.ofNullable(inMemoryRepository.get(messageId));
    }

    @Override
    public Message save(Message message) {
        return inMemoryRepository.put(message.getMessageId(), message);
    }
}
