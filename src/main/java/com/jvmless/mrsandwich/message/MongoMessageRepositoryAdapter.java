package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;
import com.jvmless.mrsandwich.receiver.MongoReceiverRepository;

import java.util.List;
import java.util.Optional;

public class MongoMessageRepositoryAdapter implements MessageRepository {

    private final MongoMessageRepository mongoMessageRepository;

    public MongoMessageRepositoryAdapter(MongoMessageRepository mongoMessageRepository) {
        this.mongoMessageRepository = mongoMessageRepository;
    }

    @Override
    public Optional<Message> findBy(MessageId messageId) {
        return mongoMessageRepository.findById(messageId);
    }

    @Override
    public Message save(Message message) {
        return mongoMessageRepository.save(message);
    }

    @Override
    public List<Message> findAll(VendorId vendorId) {
        return mongoMessageRepository.findAllByVendorId(vendorId);
    }
}
