package com.jvmless.mrsandwich.message;

public interface MessageRepository {
    Message findBy(MessageId messageId);
    Message save(Message message);
}
