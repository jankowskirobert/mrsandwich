package com.jvmless.mrsandwich.subscription;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySubscriptionRepositoryAdapter implements SubscriptionRepository {

    private Map<SubscriptionId, Subscription> inMemoryDataBase = new ConcurrentHashMap<>();


    @Override
    public void save(Subscription subscription) {
        inMemoryDataBase.put(subscription.getSubscriptionId(), subscription);
    }
}
