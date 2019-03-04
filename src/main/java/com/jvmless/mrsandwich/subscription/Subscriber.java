package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.seller.Seller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Subscriber {

    private SubscriberId subscriberId;
    private List<Subscription> currentSubscriptions;
    private SubscriberPolicy policy; // eventually here or in subscription
    private Client client;

    protected Subscriber (SubscriberId subscriberId, SubscriberPolicy policy, Client client) {
        this.subscriberId = subscriberId;
        this.policy = policy;
        this.client = client;
    }

    public void subscribe(Seller seller, Location location) {
        Optional<Subscription> already = find(seller, location);
        if (already.isPresent())
            throw new IllegalArgumentException("Already subscribed");
        else {
            currentSubscriptions.add(new Subscription(SubscriptionId.random(), client, seller, location));
        }
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
        return currentSubscriptions.stream().filter(x -> x.getSubscriptionId().equals(subscriptionId));
    }

    private Optional<Subscription> find(Seller seller, Location location) {
        return currentSubscriptions.stream().filter(x-> x.getSeller().equals(seller) && x.getLocation().equals(location)).findAny();
    }

}
