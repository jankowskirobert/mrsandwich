package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.notification.NotificationSenderPort;

public class DummyToConsoleNotificationSenderAdapter implements NotificationSenderPort {
    @Override
    public void send(String fcmRegistrationId, String messageBody) {
        System.out.println("NOTIFICATION SEND TO: " + fcmRegistrationId + " BODY: " + messageBody);
    }
}
