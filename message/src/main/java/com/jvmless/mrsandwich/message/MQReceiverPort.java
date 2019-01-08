package com.jvmless.mrsandwich.message;

public interface MQReceiverPort {
    void newClientWithLocationRegistered(String message);
}
