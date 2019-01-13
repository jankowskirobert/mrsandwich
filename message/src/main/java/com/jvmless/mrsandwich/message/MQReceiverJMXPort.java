package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.client.ClientFacade;

public class MQReceiverJMXPort implements MQReceiverPort {
    private ClientFacade clientFacade;

    public MQReceiverJMXPort(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    @Override
    public void newClientWithLocationRegistered(String message) {
        NewClientLocation newClientLocation = NewClientLocation.fromEvent(message);
        clientFacade.registerNewClientWithLocation(newClientLocation);
    }
}