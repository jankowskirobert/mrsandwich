package com.jvmless.mrsandwich.notification;

public class NotificationAlreadyExistException extends RuntimeException {
    public NotificationAlreadyExistException(String message) {
        super(message);
    }
}
