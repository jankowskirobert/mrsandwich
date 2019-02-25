package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.client.events.NewClientRegistered;
import com.jvmless.mrsandwich.message.NewClientLocation;
import org.springframework.context.event.EventListener;

public class MQReceiverSpringEventAdapter implements MQReceiverPort {

    private final ReceiverFacade receiverFacade;

    public MQReceiverSpringEventAdapter(ReceiverFacade receiverFacade) {
        this.receiverFacade = receiverFacade;
    }

    @EventListener
    @Override
    public void newClientRegistered(NewClientRegistered incomingClient) {
        receiverFacade.registerNewClientWithLocation(new NewClientLocation(incomingClient.getId()));
    }
}
