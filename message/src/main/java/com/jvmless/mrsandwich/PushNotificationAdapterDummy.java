package com.jvmless.mrsandwich;

import com.jvmless.mrsandwich.message.PushNotificationAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PushNotificationAdapterDummy implements PushNotificationAdapter {
    @Override
    public void send(String fcmRegistrationId, String messageBody) {
        log.debug("Send notification");
    }
}
