package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

interface ClientRepositoryMongoDb extends MongoRepository<Client, String> {
}
