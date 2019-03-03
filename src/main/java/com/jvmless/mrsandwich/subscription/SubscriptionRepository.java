package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.seller.Seller;

import java.util.List;

public interface SubscriptionRepository {
    void save(Subscription subscription);
    List<Client> findAllBySeller(Seller seller);
}
