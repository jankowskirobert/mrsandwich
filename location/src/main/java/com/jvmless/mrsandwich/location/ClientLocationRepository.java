package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.Client;

import java.util.Optional;

public interface ClientLocationRepository {
    Client save(Client from);

    Optional<Client> findOne(String id);
}
