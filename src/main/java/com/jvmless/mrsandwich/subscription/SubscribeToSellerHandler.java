package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientId;
import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.seller.Location;
import com.jvmless.mrsandwich.seller.LocationRepository;
import com.jvmless.mrsandwich.seller.Seller;
import com.jvmless.mrsandwich.seller.SellerRepository;

import java.util.Optional;

public class SubscribeToSellerHandler {

    private ClientRepository clientRepository;
    private SellerRepository sellerRepository;
    private LocationRepository locationRepository;
    private SubscribtionRepository subscribtionRepository;

    public SubscribeToSellerHandler(ClientRepository clientRepository, SellerRepository sellerRepository, LocationRepository locationRepository, SubscribtionRepository subscribtionRepository) {
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
        this.locationRepository = locationRepository;
        this.subscribtionRepository = subscribtionRepository;
    }

    public void handle(SubscribeToSeller subscribeToSeller) {
        Optional<Client> client = clientRepository.findById(new ClientId(subscribeToSeller.getClientId()));
        Optional<Seller> seller = sellerRepository.find(subscribeToSeller.getSellerId());
        Optional<Location> clientLocation = locationRepository.findById(subscribeToSeller.getLocationId());

        Subscribtion subscribtion = new Subscribtion(
                new SubscribtionId(subscribeToSeller.getSubscriptionId()),
                client.get(),
                seller.get(),
                clientLocation.get()
        );
        subscribtionRepository.save(subscribtion);
    }
}
