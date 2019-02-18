package com.jvmless.mrsandwich.notification;

public interface NotificationSenderPort {
    void send(String fcmRegistrationId, String messageBody);
}
