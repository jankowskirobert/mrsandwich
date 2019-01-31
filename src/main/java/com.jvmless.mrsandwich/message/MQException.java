package com.jvmless.mrsandwich.message;

public class MQException extends RuntimeException {
    public MQException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
