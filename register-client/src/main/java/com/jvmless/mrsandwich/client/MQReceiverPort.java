package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.exceptions.MQException;

public interface MQReceiverPort {

    void newSellerRegistrationMessage(String message) throws MQException;
}
