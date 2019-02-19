package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.TargetId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface MongoReceiverRepository extends MongoRepository<Receiver, String> {
    Stream<Receiver> findByTargetId(TargetId targetId);
}
