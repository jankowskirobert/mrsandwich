package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.TargetId;

import java.util.Optional;
import java.util.stream.Stream;

public class MongoReceiverRepositoryAdapter implements ReceiverRepository {

    private final MongoReceiverRepository mongoReceiverRepository;

    public MongoReceiverRepositoryAdapter(MongoReceiverRepository mongoReceiverRepository) {
        this.mongoReceiverRepository = mongoReceiverRepository;
    }

    @Override
    public void save(Receiver receiver) {
        this.mongoReceiverRepository.save(receiver);
    }

    @Override
    public Stream<Receiver> findAll() {
        return this.mongoReceiverRepository.findAll().stream();
    }

    @Override
    public Optional<Receiver> find(ClientId id) {
        String receiverId = id.getId();
        return mongoReceiverRepository.findById(receiverId);
    }

    @Override
    public Stream<Receiver> findByTargetArea(TargetId targetArea) {
        return mongoReceiverRepository.findByTargetId(targetArea);
    }
}
