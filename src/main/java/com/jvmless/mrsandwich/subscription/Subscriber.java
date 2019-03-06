package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.publication.PublisherId;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.seller.Seller;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
public class Subscriber {

    private SubscriberId subscriberId;
    private List<Subscription> subscriptions;
    private SubscriberPolicy policy; // eventually here or in subscription
    private Client client;

    protected Subscriber (SubscriberId subscriberId, SubscriberPolicy policy, Client client) {
        this.subscriberId = subscriberId;
        this.policy = policy;
        this.client = client;
    }

    public void subscribe(PublisherId publisherId, Location location) {
        if (isSubscribing(publisherId, location))
            throw new IllegalArgumentException("Already subscribed");
        else {
            subscriptions.add(new Subscription(SubscriptionId.random(), client, publisherId, location));
        }
    }

    public boolean isSubscribing(PublisherId publisherId, Location location) {
        Optional<Subscription> already = find(publisherId, location);
        return already.isPresent();
    }

    public void unsubscribe(SubscriptionId subscriptionId) {
        Optional<Subscription> already = getSubscriptionStream(subscriptionId).findFirst();
        if(!already.isPresent())
            throw new IllegalArgumentException("Subscription unavailable");
        else {
            Stream<Subscription> subscriptionStream = getSubscriptionStream(subscriptionId);
            subscriptionStream.forEach(Subscription::deactivate);
        }
    }

    private Stream<Subscription> getSubscriptionStream(SubscriptionId subscriptionId) {
        return subscriptions.stream().filter(x -> x.getSubscriptionId().equals(subscriptionId));
    }

    private Optional<Subscription> find(PublisherId publisherId, Location location) {
        return subscriptions.stream().filter(x-> x.getPublisherId().equals(publisherId) && x.getLocation().equals(location)).findAny();
    }

}
