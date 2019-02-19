package com.jvmless.mrsandwich.message;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoMessageRepository extends MongoRepository<Message, MessageId> {
}
