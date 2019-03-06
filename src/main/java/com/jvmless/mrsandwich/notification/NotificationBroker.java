package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.client.publication.Publisher;
import com.jvmless.mrsandwich.client.publication.PublisherId;
import com.jvmless.mrsandwich.client.publication.PublisherRepository;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.subscription.Subscriber;
import com.jvmless.mrsandwich.subscription.SubscriberRepository;

import java.util.List;
import java.util.UUID;

public class NotificationBroker {

    private PublisherRepository publisherRepository;
    private SubscriberRepository subscriberRepository;
    private NotificationSendingService notificationSendingService;

    public void notifySubscribers(PublisherId publisherId, Message message, Location location) {
        List<Subscriber> subscriberList = subscriberRepository.findBySubscriptionsPublisherIdAndSubscriptionsLocation(publisherId, location);
        if(subscriberList.size() > 0) {
            Publisher publisher = publisherRepository.find(publisherId);
            publisher.publish(message, location);
            publisherRepository.save(publisher);
            subscriberList.parallelStream().forEach(x -> {
                notificationSendingService.sendMessage(x.getSubscriberId(), publisherId, message, location);
            });
        }
    }
}
