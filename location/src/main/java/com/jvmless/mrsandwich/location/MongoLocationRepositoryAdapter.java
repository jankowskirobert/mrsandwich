package com.jvmless.mrsandwich.location;

import java.util.Optional;

public class MongoLocationRepositoryAdapter implements ClientLocationRepository {

    private MongoLocationRepository mongoLocationRepository;

    public MongoLocationRepositoryAdapter(MongoLocationRepository mongoLocationRepository) {
        this.mongoLocationRepository = mongoLocationRepository;
    }

    @Override
    public Client save(Client client) {
        return mongoLocationRepository.save(client);
    }

    @Override
    public Optional<Client> findOne(String id) {
        return mongoLocationRepository.findById(id);
    }
}
