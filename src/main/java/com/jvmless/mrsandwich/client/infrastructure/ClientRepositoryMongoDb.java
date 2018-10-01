package com.jvmless.mrsandwich.client.infrastructure;

import com.jvmless.mrsandwich.client.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

interface ClientRepositoryMongoDb extends MongoRepository<Client, String> {
}
