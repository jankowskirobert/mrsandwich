package com.jvmless.mrsandwich.location;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ClientLocationRepositoryInMemory implements ClientLocationRepository {

    private Map<String, Client> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Client save(Client client) {
        Client inMemory = inMemoryRepository.put(client.getId(), client);
        return Optional.ofNullable(inMemory).orElse(client);
    }

    @Override
    public Optional<Client> findOne(String id) {
        return Optional.ofNullable(inMemoryRepository.get(id));
    }
}
