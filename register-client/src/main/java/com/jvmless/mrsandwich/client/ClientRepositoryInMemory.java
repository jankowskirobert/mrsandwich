package com.jvmless.mrsandwich.client;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@NoArgsConstructor
class ClientRepositoryInMemory implements ClientRepository {
    private Map<String, Client> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Optional<Client> findById(ClientId clientId) {
        return Optional.ofNullable(inMemoryRepository.get(clientId.id()));
    }

    @Override
    public Client save(Client x) {
        if (inMemoryRepository.containsKey(x.id()))
            throw new RuntimeException("Already in Db");
        return inMemoryRepository.put(x.id(), x);
    }

    @Override
    public Client update(Client x) {
        return inMemoryRepository.merge(x.id(), x, (oldVal, newVal) -> {
            log.info("Update Client: {}", oldVal.id());
            return newVal;
        });
    }

    @Override
    public ClientStats fullStats() {
        int count = inMemoryRepository.size();
        long active = inMemoryRepository.values().stream().filter(x -> x.isEnable()).count();
        return new ClientStats();
    }

    @Override
    public void removeAll() {
        inMemoryRepository.clear();
    }
}
