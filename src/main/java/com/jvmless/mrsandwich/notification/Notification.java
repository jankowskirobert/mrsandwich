package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.receiver.Receiver;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.Data;

@Data
public class Notification {
    private NotificationId notificationId;
    private Receiver receiver;
    private TargetId target;
    private Vendor vendor;
    private Message message;
    private NotificationStatus status;


    public Notification(NotificationId notificationId, Receiver receiver, Vendor vendor, Message message, NotificationStatus status) {
        this.notificationId = notificationId;
        this.receiver = receiver;
        isMessageAndSenderMatch(vendor, message);
        this.status = status;
    }

    private void isMessageAndSenderMatch(Vendor vendor, Message message) {
        if(vendor.getVendorId().equals(message.getOwner())) {
            this.vendor = vendor;
            this.message = message;
        } else {
            throw new IllegalStateException("Notification sender doesn't match message owner");
        }
    }
}
