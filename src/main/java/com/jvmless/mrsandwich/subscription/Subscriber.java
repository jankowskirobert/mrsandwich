package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.seller.Seller;

import java.util.List;
import java.util.Optional;

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

    public boolean subscribe(Seller seller, Location location) {
        Optional<Subscription> already = find(seller, location);
      if(already.isPresent())
          throw new IllegalArgumentException("Already subscribed");
      else {
          currentSubscriptions.add(new Subscription(SubscriptionId.random(), client, seller, location));
          return true;
      }
    }

    private Optional<Subscription> find(Seller seller, Location location) {
        return currentSubscriptions.stream().filter(x-> x.getSeller().equals(seller) && x.getLocation().equals(location)).findAny();
    }

}
