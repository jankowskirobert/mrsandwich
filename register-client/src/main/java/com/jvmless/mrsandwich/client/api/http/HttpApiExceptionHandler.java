package com.jvmless.mrsandwich.client.api.http;

import com.jvmless.mrsandwich.client.exceptions.ClientRegisterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class HttpApiExceptionHandler {
    @ResponseStatus(value= HttpStatus.BAD_REQUEST,
            reason="Data integrity violation")  // 409
    @ExceptionHandler(ClientRegisterException.class)
    public void conflict(ClientRegisterException ex) {
        // Nothing to do
    }
}
