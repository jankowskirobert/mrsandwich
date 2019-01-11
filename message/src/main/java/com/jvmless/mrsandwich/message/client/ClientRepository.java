package com.jvmless.mrsandwich.message.client;

import com.jvmless.mrsandwich.message.client.Client;

import java.util.stream.Stream;

public interface ClientRepository {
    void save(Client client);
    Stream<Client> findAll();
}
