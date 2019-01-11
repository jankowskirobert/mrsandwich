package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.client.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private NotificationId notificationId;
    private Client clientId;
    private TargetArea targetId;
    private Seller seller;
    private MessageId message;
}
