package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import com.jvmless.mrsandwich.seller.dto.mq.NewSellerRegistrationEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitSender implements MQSender {

    private RabbitTemplate rabbitTemplate;

    public RabbitSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void newSellerregistrationMessage(SellerRegisterDto sellerDto) {
        NewSellerRegistrationEvent newSellerRegistrationEvent = new NewSellerRegistrationEvent(sellerDto.getId());
        this.rabbitTemplate.convertAndSend("", "", newSellerRegistrationEvent.message());
    }
}
