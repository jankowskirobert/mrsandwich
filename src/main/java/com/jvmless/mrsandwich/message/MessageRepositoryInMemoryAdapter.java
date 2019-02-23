package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

    @Override
    public List<Message> findAll(VendorId vendorId) {
        return inMemoryRepository.values().stream().filter(x -> x.getOwner().equals(vendorId)).collect(Collectors.toList());
    }
}
