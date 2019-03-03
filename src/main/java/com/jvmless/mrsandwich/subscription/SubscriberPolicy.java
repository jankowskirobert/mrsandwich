package com.jvmless.mrsandwich.subscription;

import com.jvmless.mrsandwich.seller.Seller;

public interface SubscriberPolicy {
    boolean canSubscribe(Seller seller);
}
