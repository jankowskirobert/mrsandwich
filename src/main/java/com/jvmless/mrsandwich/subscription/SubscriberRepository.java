package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.publication.PublisherId;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.seller.Seller;

import java.util.List;

public interface SubscriberRepository {
    Subscriber find(SubscriberId subscriberId);
    void save(Subscriber subscriber);
    List<Subscriber> findBySubscriptionsPublisherIdAndSubscriptionsLocation(PublisherId publisherId, Location location);
}
