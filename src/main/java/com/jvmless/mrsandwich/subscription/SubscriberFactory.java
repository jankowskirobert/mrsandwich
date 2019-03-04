package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;

public class SubscriberFactory {

    public static Subscriber create(Client client) {
        return new Subscriber(SubscriberId.random(),null, client);
    }
}
