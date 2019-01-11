package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.client.ClientId;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private NotificationId notificationId;
    private ClientId clientId;
}
