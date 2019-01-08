package com.jvmless.mrsandwich.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

class ClientRepositoryInMemoryAdapter implements ClientRepository {

    private Map<String, Client> inMemoryRepository = new ConcurrentHashMap<>();


    @Override
    public void save(Client client) {
        inMemoryRepository.put(client.getId(), client);
    }

    @Override
    public Stream<Client> findAll() {
        return inMemoryRepository.entrySet().stream().map(x -> x.getValue());
    }
}