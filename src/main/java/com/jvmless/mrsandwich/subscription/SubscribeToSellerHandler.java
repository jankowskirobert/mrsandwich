package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientId;
import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.location.LocationId;
import com.jvmless.mrsandwich.location.LocationRepository;
import com.jvmless.mrsandwich.seller.Seller;
import com.jvmless.mrsandwich.seller.SellerId;
import com.jvmless.mrsandwich.seller.SellerRepository;

public class SubscribeToSellerHandler {

    private ClientRepository clientRepository;
    private SellerRepository sellerRepository;
    private LocationRepository locationRepository;
    private SubscriptionRepository subscriptionRepository;

    public SubscribeToSellerHandler(ClientRepository clientRepository, SellerRepository sellerRepository, LocationRepository locationRepository, SubscriptionRepository subscriptionRepository) {
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
        this.locationRepository = locationRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public void handle(SubscribeToSeller subscribeToSeller) {
        Client client = clientRepository.findById(new ClientId(subscribeToSeller.getClientId())).orElseThrow(() -> new IllegalArgumentException());
        Seller seller = sellerRepository.find(new SellerId(subscribeToSeller.getSellerId())).orElseThrow(() -> new IllegalArgumentException());
        Location clientLocation = locationRepository.findById(new LocationId(subscribeToSeller.getLocationId())).orElseThrow(() -> new IllegalArgumentException());

        if(seller.isHandlingLocation(clientLocation)) {
            Subscription subscription = new Subscription(
                    new SubscriptionId(subscribeToSeller.getSubscriptionId()),
                    client,
                    seller,
                    clientLocation
            );
            subscriptionRepository.save(subscription);
        }
    }
}
