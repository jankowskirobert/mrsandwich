package com.jvmless.mrsandwich.client;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ClientRepositoryMongoDb extends MongoRepository<Client, String> {
}
