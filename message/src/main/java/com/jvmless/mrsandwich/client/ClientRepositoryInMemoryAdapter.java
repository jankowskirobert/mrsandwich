package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.message.TargetId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class ClientRepositoryInMemoryAdapter implements ClientRepository {

    private Map<String, Client> inMemoryRepository = new ConcurrentHashMap<>();


    @Override
    public void save(Client client) {
        inMemoryRepository.put(client.getId(), client);
    }

    @Override
    public Stream<Client> findAll() {
        return inMemoryRepository.entrySet().stream().map(x -> x.getValue());
    }

    @Override
    public Client find(ClientId id) {
        return inMemoryRepository.get(id.getId());
    }

    @Override
    public Stream<Client> findByTargetArea(TargetId targetArea) {
        return inMemoryRepository.entrySet().stream().filter(
                x -> x.getValue().getTargetId().equals(targetArea)
        ).map(y -> y.getValue());
    }
}
