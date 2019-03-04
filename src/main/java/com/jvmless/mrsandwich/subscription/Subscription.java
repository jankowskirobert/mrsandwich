package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.seller.Seller;
import lombok.Data;

import java.time.LocalDateTime;

//Agregat
/*
can only handle client rules, so for example client can only have 3 subscriptions
 */
@Data
public class Subscription {
    private SubscriptionId subscriptionId;
    private Seller seller;
    private Location location;
    private SubscriptionStatus subscriptionStatus;
    private LocalDateTime subscriptionStart;
    private LocalDateTime subscriptionEnd;

    protected Subscription(SubscriptionId subscriptionId, Client client, Seller seller, Location location) {
        this.subscriptionId = subscriptionId;
        this.seller = seller;
        this.location = location;
        this.subscriptionStatus = SubscriptionStatus.ACTIVATED;
        this.subscriptionStart = LocalDateTime.now();
    }

    public void deactivate() {
        subscriptionStatus = SubscriptionStatus.DEACTIVATED;
        subscriptionEnd = LocalDateTime.now();
    }
}
