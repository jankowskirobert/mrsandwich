package com.jvmless.mrsandwich.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationSender {
    private NotificationSenderId notificationSenderId;
}
