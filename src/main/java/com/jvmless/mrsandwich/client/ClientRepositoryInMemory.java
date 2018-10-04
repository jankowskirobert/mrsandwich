package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
class ClientRepositoryInMemory implements ClientRepository {
    private Map<String, Client> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Optional<Client> findById(String clientId) {
        return Optional.ofNullable(inMemoryRepository.get(clientId));
    }

    @Override
    public Client save(Client x) {
        if(inMemoryRepository.containsKey(x.id()))
            throw new RuntimeException("Already in Db");
        return inMemoryRepository.put(x.id(), x);
    }

    @Override
    public Client update(Client x) {
        return inMemoryRepository.merge(x.id(), x, (oldVal, newVal) -> {log.info("Update Client: {}", oldVal.id());return newVal;});
    }

    @Override
    public void removeAll() {
        inMemoryRepository.clear();
    }
}
