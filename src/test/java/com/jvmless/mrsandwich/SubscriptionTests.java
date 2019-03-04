package com.jvmless.mrsandwich;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientFactory;
import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.client.ClientRepositoryInMemory;
import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.location.LocationId;
import com.jvmless.mrsandwich.location.LocationRepository;
import com.jvmless.mrsandwich.location.LocationRepositoryInMemory;
import com.jvmless.mrsandwich.seller.*;
import com.jvmless.mrsandwich.subscription.*;
import org.junit.Test;

public class SubscriptionTests {

    ClientRepository clientRepository = new ClientRepositoryInMemory();
    SellerRepository sellerRepository = new SellerRepositoryInMemory();
    LocationRepository locationRepository = new LocationRepositoryInMemory();
    SubscriptionRepository subscriptionRepository = new InMemorySubscriptionRepositoryAdapter();
    SubscribeToSellerHandler handler = new SubscribeToSellerHandler(
            clientRepository,
            sellerRepository,
            locationRepository,
            subscriptionRepository);

    @Test
    public void testSubscription() {
        Location location = new Location(new LocationId("locationName"));
        locationRepository.save(location);
        Seller seller = SellerFactory.createNeSeller("seller", location);
        sellerRepository.save(seller);
        Client client = ClientFactory.createNewClient("client");
        clientRepository.save(client);


        SubscribeToSeller subscribeToSeller = new SubscribeToSeller();
        subscribeToSeller.setClientId(client.id());
        subscribeToSeller.setLocationId(location.getLocationName().getId());
        subscribeToSeller.setSellerId(seller.getId().getId());
        subscribeToSeller.setSubscriptionId("SUB-1");

        handler.handle(subscribeToSeller);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubscription_sellerNotHandleLocation() {
        Location locationHandled = new Location(new LocationId("locationName"));
        Location unhandled = new Location(new LocationId("locationId_2"));

        locationRepository.save(locationHandled);
        Seller seller = SellerFactory.createNeSeller("seller", unhandled);
        sellerRepository.save(seller);
        Client client = ClientFactory.createNewClient("client");
        clientRepository.save(client);


        SubscribeToSeller subscribeToSeller = new SubscribeToSeller();
        subscribeToSeller.setClientId(client.id());
        subscribeToSeller.setLocationId(locationHandled.getLocationName().getId());
        subscribeToSeller.setSellerId(seller.getId().getId());
        subscribeToSeller.setSubscriptionId("SUB-1");

        handler.handle(subscribeToSeller);
    }

    @Test
    public void testSubscriber() {
        Client client = ClientFactory.createNewClient("client");
        Location locationHandled = new Location(new LocationId("locationName"));
        Seller seller = SellerFactory.createNeSeller("seller", locationHandled);
        Subscriber subscriber = SubscriberFactory.create(client);
        subscriber.subscribe(seller, locationHandled);
    }
}
