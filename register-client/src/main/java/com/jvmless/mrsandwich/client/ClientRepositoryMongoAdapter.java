package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.exceptions.ClientRegisterDuplicateKeyException;
import org.springframework.dao.DuplicateKeyException;

import java.util.Optional;

class ClientRepositoryMongoAdapter implements ClientRepository {

    private final ClientRepositoryMongoDb clientRepository;

    public ClientRepositoryMongoAdapter(ClientRepositoryMongoDb clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(ClientId clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public Client save(Client x) {
        try {
            return clientRepository.insert(x);
        } catch (DuplicateKeyException exception) {
            throw new ClientRegisterDuplicateKeyException(String.format("Client %s already in database!", x.id()), exception);
        }
    }

    @Override
    public Client update(Client x) {
        return clientRepository.save(x);
    }

    @Override
    public ClientStats fullStats() {
        return new ClientStats();
    }

    @Override
    public void removeAll() {
        clientRepository.deleteAll();
    }
}
