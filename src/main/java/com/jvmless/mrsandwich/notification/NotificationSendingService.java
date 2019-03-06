package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.client.publication.PublisherId;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.subscription.SubscriberId;

public interface NotificationSendingService {
    void sendMessage(SubscriberId subscriberId, PublisherId publisherId, Message message, Location location);
}
