package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.TargetId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class ReceiverRepositoryInMemoryAdapter implements ReceiverRepository {

    private Map<String, Receiver> inMemoryRepository = new ConcurrentHashMap<>();


    @Override
    public void save(Receiver receiver) {
        inMemoryRepository.put(receiver.getId(), receiver);
    }

    @Override
    public Stream<Receiver> findAll() {
        return inMemoryRepository.entrySet().stream().map(x -> x.getValue());
    }

    @Override
    public Receiver find(ClientId id) {
        return inMemoryRepository.get(id.getId());
    }

    @Override
    public Stream<Receiver> findByTargetArea(TargetId targetArea) {
        return inMemoryRepository.entrySet().stream().filter(
                x -> x.getValue().getTargetId().equals(targetArea)
        ).map(y -> y.getValue());
    }
}
