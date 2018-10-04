package com.jvmless.mrsandwich.client.exceptions;

public class CorrelationDeactivateException extends RuntimeException {
    public CorrelationDeactivateException(String correlation_never_started) {
    }
}
