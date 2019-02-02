package com.jvmless.mrsandwich.client.mqadapters;

import com.jvmless.mrsandwich.client.ClientFacade;
import com.jvmless.mrsandwich.client.MQReceiverPort;
import com.jvmless.mrsandwich.client.dto.NewSeller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MQReceiverAdapterDummy implements MQReceiverPort {

    private ClientFacade clientFacade;

    public MQReceiverAdapterDummy(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    @Override
    public void newSellerRegistrationMessage(String message) {
        clientFacade.newSellerRegister(NewSeller.dispatchJson(message));
    }
}
