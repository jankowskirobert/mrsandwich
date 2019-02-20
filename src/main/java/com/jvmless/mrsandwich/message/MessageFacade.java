package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.message.api.CreateMessage;
import com.jvmless.mrsandwich.notification.VendorId;

import java.time.LocalDateTime;

public class MessageFacade {

    private final MessageRepository messageRepository;

    public MessageFacade(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addNewMessage(CreateMessage addNewMessage) {
        MessageId messageId = MessageId.of(addNewMessage.getMessageId());
        VendorId vendorId = VendorId.of(addNewMessage.getVendorId());
        Message newMessage = Message.of(messageId, addNewMessage.getMessageBody(), vendorId, LocalDateTime.now(), addNewMessage.getMessageStatus());
        messageRepository.save(newMessage);
    }
}
