package com.jvmless.mrsandwich.message;

import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findBy(MessageId messageId);
    Message save(Message message);
}
