package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.NewSeller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@Slf4j
class MQReceiverPortDummy implements MQReceiverPort {

    private ClientFacade clientFacade;

    public MQReceiverPortDummy(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    @Override
    public void newSellerRegistrationMessage(String message) {
        clientFacade.newSellerRegister(NewSeller.dispatchJson(message));
    }
}
