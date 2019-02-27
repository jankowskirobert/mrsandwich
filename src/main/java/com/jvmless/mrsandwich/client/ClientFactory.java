package com.jvmless.mrsandwich.client;

public class ClientFactory {

    public static Client createNewClient(String id) {
        return new Client(new ClientId(id), ClientStatus.ENABLE);
    }
}
