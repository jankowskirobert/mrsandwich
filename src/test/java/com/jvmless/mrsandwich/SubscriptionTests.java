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
import com.jvmless.mrsandwich.subscription.InMemorySubscriptionRepositoryAdapter;
import com.jvmless.mrsandwich.subscription.SubscribeToSeller;
import com.jvmless.mrsandwich.subscription.SubscribeToSellerHandler;
import com.jvmless.mrsandwich.subscription.SubscriptionRepository;
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
        Location location = new Location(new LocationId("locationId"));
        locationRepository.save(location);
        Seller seller = SellerFactory.createNeSeller("sellerId", location);
        sellerRepository.save(seller);
        Client client = ClientFactory.createNewClient("clientId");
        clientRepository.save(client);

        SubscribeToSeller subscribeToSeller = new SubscribeToSeller();
        subscribeToSeller.setClientId(client.id());
        subscribeToSeller.setLocationId(location.getLocationId().getId());
        subscribeToSeller.setSellerId(seller.getId().getId());
        subscribeToSeller.setSubscriptionId("SUB-1");

        handler.handle(subscribeToSeller);
    }
}
