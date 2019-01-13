package com.jvmless.mrsandwich.message.client;

import com.jvmless.mrsandwich.message.TargetArea;
import com.jvmless.mrsandwich.message.TargetId;
import com.jvmless.mrsandwich.message.client.Client;

import java.util.stream.Stream;

public interface ClientRepository {
    void save(Client client);
    Stream<Client> findAll();
    Client find(ClientId id);

    Stream<Client> findByTargetArea(TargetId targetArea);
}
