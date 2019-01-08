package com.jvmless.mrsandwich.message;

import java.util.stream.Stream;

public interface ClientRepository {
    void save(Client client);
    Stream<Client> findAll();
}
