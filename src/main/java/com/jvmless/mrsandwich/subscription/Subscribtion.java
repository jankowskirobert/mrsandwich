package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.seller.Location;
import com.jvmless.mrsandwich.seller.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;

//Agregat
@Data
@AllArgsConstructor
public class Subscribtion {
    private SubscribtionId subscribtionId;
    private Client clientId;
    private Seller sellerId;
    private Location locationId;

    public Subscribtion(SubscribtionId subscribtionId, Client clientId, Seller sellerId, Location locationId) {
        if(!sellerId.isHandlingLocation(locationId)) {
            throw new IllegalArgumentException("Cannot handle location by given seller");
        }
        this.subscribtionId = subscribtionId;
        this.clientId = clientId;
        this.sellerId = sellerId;
        this.locationId = locationId;
    }
}
