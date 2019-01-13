package com.jvmless.mrsandwich.message;

public interface PushNotificationAdapter {
    void send(String fcmRegistrationId, String messageBody);
}
