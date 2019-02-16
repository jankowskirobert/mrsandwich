package com.jvmless.mrsandwich.notification.commands;

import com.jvmless.mrsandwich.notification.NotificationId;
import com.jvmless.mrsandwich.message.MessageId;
import com.jvmless.mrsandwich.notification.VendorId;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "by")
@Data
public class NotifyClients {
    private NotificationId notificationId = NotificationId.random();
    private VendorId vendorId;
    private MessageId messageId;
    private LocalDateTime establishedDelivery;
    private TargetId targetArea;
}
