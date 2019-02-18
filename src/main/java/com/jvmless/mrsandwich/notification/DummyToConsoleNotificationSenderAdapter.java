package com.jvmless.mrsandwich.notification;

public class DummyToConsoleNotificationSenderAdapter implements NotificationSenderPort {
    @Override
    public void send(String fcmRegistrationId, String messageBody) {
        System.out.println("NOTIFICATION SEND TO: " + fcmRegistrationId + " BODY: " + messageBody);
    }
}
