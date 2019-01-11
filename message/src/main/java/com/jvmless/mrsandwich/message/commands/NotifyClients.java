package com.jvmless.mrsandwich.message.commands;

import com.jvmless.mrsandwich.NotificationId;
import com.jvmless.mrsandwich.message.SellerId;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "by")
@Data
public class NotifyClients {
    private NotificationId notificationId = NotificationId.random();
    private SellerId sellerId;
    private String message;
    private LocalDateTime establishedDelivery;
    private TargetId targetArea;
}
