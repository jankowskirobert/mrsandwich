package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.message.TargetId;

import java.util.stream.Stream;

public interface ClientRepository {
    void save(Client client);
    Stream<Client> findAll();
    Client find(ClientId id);

    Stream<Client> findByTargetArea(TargetId targetArea);
}
