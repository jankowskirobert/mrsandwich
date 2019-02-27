package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.seller.Seller;
import lombok.Data;

import java.time.LocalDateTime;

//Agregat
@Data
public class Subscription {
    private SubscriptionId subscriptionId;
    private Client clientId;
    private Seller sellerId;
    private Location locationId;
    private SubscriptionStatus subscriptionStatus;
    private LocalDateTime subscriptionStart;
    private LocalDateTime subscriptionEnd;

    public Subscription(SubscriptionId subscriptionId, Client clientId, Seller sellerId, Location locationId) {
        this.subscriptionId = subscriptionId;
        this.clientId = clientId;
        this.sellerId = sellerId;
        this.locationId = locationId;
        this.subscriptionStatus = SubscriptionStatus.ACTIVATED;
        this.subscriptionStart = LocalDateTime.now();
    }

    public void deactivate() {
        subscriptionStatus = SubscriptionStatus.DEACTIVATED;
        subscriptionEnd = LocalDateTime.now();
    }
}
