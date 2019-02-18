package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.receiver.Receiver;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private NotificationId notificationId;
    private List<Recipient> receivers = new ArrayList<>();
    private TargetId target;
    private Vendor vendor;
    private MessageDetails message;
    private NotificationStatus status;


    public Notification(NotificationId notificationId, Vendor vendor, MessageDetails message) {
        this.notificationId = notificationId;
        this.message = message;
        this.vendor = vendor;
        this.status = NotificationStatus.WAITING;
    }

    public void addReceiver(Recipient receiver) {
        if(receivers.contains(receiver))
            throw new IllegalArgumentException("Receiver already signed");
        else
            receivers.add(receiver);
    }

    public int countRecivers() {
        return receivers.size();
    }

    public void delivered() {
        this.status = NotificationStatus.FINISHED_SENDING;
    }
}
