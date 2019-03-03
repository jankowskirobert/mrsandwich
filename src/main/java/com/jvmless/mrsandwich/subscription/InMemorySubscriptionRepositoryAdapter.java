package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.seller.Seller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemorySubscriptionRepositoryAdapter implements SubscriptionRepository {

    private Map<SubscriptionId, Subscription> inMemoryDataBase = new ConcurrentHashMap<>();


    @Override
    public void save(Subscription subscription) {
        inMemoryDataBase.put(subscription.getSubscriptionId(), subscription);
    }

    @Override
    public List<Client> findAllBySeller(Seller seller) {
        return inMemoryDataBase.entrySet()
                .stream()
                .filter(sub -> sub.getValue().getSeller().equals(seller))
                .map(sub -> sub.getValue().getClient())
                .collect(Collectors.toList());
    }
}
