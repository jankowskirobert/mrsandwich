package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.client.events.NewClientRegistered;

public interface MQReceiver {

    void newClientRegistered(NewClientRegistered incomingClient);

}
