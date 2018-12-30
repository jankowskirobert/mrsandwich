package com.jvmless.mrsandwich.client;

public interface MQReceiverPort {

    void newSellerRegistrationMessage(String message);
}
