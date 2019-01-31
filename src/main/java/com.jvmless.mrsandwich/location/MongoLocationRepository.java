package com.jvmless.mrsandwich.location;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoLocationRepository extends MongoRepository<Client, String> {
}
