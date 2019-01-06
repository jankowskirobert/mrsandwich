package com.jvmless.mrsandwich.location;

import java.util.Optional;

public interface ClientLocationRepository {
    Client save(Client client);

    Optional<Client> findOne(String id);
}
