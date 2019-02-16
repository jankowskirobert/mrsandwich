package com.jvmless.mrsandwich.notification;

public interface PushNotificationAdapter {
    void send(String fcmRegistrationId, String messageBody);
}
