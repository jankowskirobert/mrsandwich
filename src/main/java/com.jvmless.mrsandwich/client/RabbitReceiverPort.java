package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.ClientFacade;
import com.jvmless.mrsandwich.client.MQReceiverPort;
import com.jvmless.mrsandwich.client.dto.NewSeller;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RabbitListener
class RabbitReceiverPort implements MQReceiverPort {

    private ClientFacade clientFacade;

    public RabbitReceiverPort(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    @RabbitHandler
    @Override
    public void newSellerRegistrationMessage(String message) {
        clientFacade.newSellerRegister(NewSeller.dispatchJson(message));
    }
}
