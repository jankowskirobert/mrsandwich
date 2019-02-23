package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findBy(MessageId messageId);
    Message save(Message message);
    List<Message> findAll(VendorId vendorId);
}
