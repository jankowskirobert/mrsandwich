package com.jvmless.mrsandwich.message.notification.commands;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.MessageId;
import com.jvmless.mrsandwich.message.NotificationSenderId;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "by")
@Data
public class NotifyClients {
    private NotificationId notificationId = NotificationId.random();
    private NotificationSenderId notificationSenderId;
    private MessageId messageId;
    private LocalDateTime establishedDelivery;
    private TargetId targetArea;
}
