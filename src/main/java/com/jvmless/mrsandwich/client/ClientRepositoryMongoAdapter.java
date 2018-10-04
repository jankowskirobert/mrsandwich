package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.client.ClientRepositoryMongoDb;

import java.util.Optional;

class ClientRepositoryMongoAdapter implements ClientRepository {

    private final ClientRepositoryMongoDb clientRepository;

    public ClientRepositoryMongoAdapter(ClientRepositoryMongoDb clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(String clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public Client save(Client x) {
        return clientRepository.insert(x);
    }

    @Override
    public Client update(Client x) {
        return clientRepository.save(x);
    }

    @Override
    public void removeAll() {
        clientRepository.deleteAll();
    }
}
