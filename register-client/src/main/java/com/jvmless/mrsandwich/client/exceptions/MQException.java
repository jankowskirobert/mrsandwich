package com.jvmless.mrsandwich.client.exceptions;

public class MQException extends RuntimeException {
    public MQException(String message, Throwable exception) {
        super(message, exception);
    }
}
