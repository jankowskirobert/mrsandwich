package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.client.publication.PublisherId;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.message.TargetId;
import com.jvmless.mrsandwich.subscription.Subscriber;
import com.jvmless.mrsandwich.subscription.SubscriberId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "notifications")
@AllArgsConstructor
public class Notification {
    @Id
    private NotificationId notificationId;
    private SubscriberId subscriber;
    private PublisherId publisherId;
    private Message message;
    private Location location;

}
