package com.jvmless.mrsandwich.client.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST,
        reason="Client already exist!")
public class ClientRegisterDuplicateKeyException extends DuplicateKeyException {
    public ClientRegisterDuplicateKeyException(String msg) {
        super(msg);
    }

    public ClientRegisterDuplicateKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
