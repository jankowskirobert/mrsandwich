package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.message.api.CreateMessage;
import com.jvmless.mrsandwich.notification.VendorId;
import com.jvmless.mrsandwich.seller.SellerRepository;
import com.jvmless.mrsandwich.seller.exceptions.SellerNotFoundException;

import java.time.LocalDateTime;

public class MessageFacade {

    private final MessageRepository messageRepository;
    private final SellerRepository sellerRepository;

    public MessageFacade(MessageRepository messageRepository, SellerRepository sellerRepository) {
        this.messageRepository = messageRepository;
        this.sellerRepository = sellerRepository;
    }

    public void addNewMessage(CreateMessage addNewMessage) {
        MessageId messageId = MessageId.of(addNewMessage.getMessageId());
        VendorId vendorId = VendorId.of(addNewMessage.getVendorId());
        if(!sellerRepository.find(addNewMessage.getVendorId()).isPresent()){
            throw new SellerNotFoundException("Seller not found");
        }
        Message newMessage = Message.of(messageId, addNewMessage.getMessageBody(), vendorId, LocalDateTime.now(), addNewMessage.getMessageStatus());
        messageRepository.save(newMessage);
    }
}
