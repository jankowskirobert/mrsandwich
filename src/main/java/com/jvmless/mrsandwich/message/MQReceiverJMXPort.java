package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.receiver.ReceiverFacade;

public class MQReceiverJMXPort implements MQReceiverPort {
    private ReceiverFacade receiverFacade;

    public MQReceiverJMXPort(ReceiverFacade receiverFacade) {
        this.receiverFacade = receiverFacade;
    }

    @Override
    public void newClientWithLocationRegistered(String message) {
        NewClientLocation newClientLocation = NewClientLocation.fromEvent(message);
        receiverFacade.registerNewClientWithLocation(newClientLocation);
    }
}