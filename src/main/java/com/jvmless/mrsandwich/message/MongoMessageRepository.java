package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoMessageRepository extends MongoRepository<Message, MessageId> {
    List<Message> findAllByVendorId(VendorId vendorId);
}
