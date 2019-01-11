package com.jvmless.mrsandwich.message;

public class NotificationAlreadyExistException extends RuntimeException {
    public NotificationAlreadyExistException(String message) {
        super(message);
    }
}
