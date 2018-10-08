package com.jvmless.mrsandwich.client.exceptions;

public class ClientRegisterException extends IllegalStateException {
    public ClientRegisterException(Exception ex) {
        super(ex);
    }
}
