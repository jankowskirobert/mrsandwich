package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.client.events.NewClientRegistered;

public interface MQReceiverPort {

    void newClientRegistered(NewClientRegistered incomingClient);

}
