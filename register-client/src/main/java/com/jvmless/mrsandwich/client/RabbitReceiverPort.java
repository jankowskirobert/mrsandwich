package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.NewSeller;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener
class RabbitReceiverPort implements MQReceiverPort {

    ClientFacade clientFacade;

    public RabbitReceiverPort(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    @RabbitHandler
    @Override
    public void newSellerRegistrationMessage(String message) {
        clientFacade.newSellerRegister(NewSeller.dispatchJson(message));
    }
}
