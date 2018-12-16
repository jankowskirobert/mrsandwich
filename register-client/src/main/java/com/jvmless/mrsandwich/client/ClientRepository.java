package com.jvmless.mrsandwich.client;

import java.util.Optional;

/*
    Make Mongo through adapter
 */
public interface ClientRepository {
    Optional<Client> findById(ClientId clientId);
    Client save(Client x);
    Client update(Client x);

    void removeAll();
}
