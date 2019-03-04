package com.jvmless.mrsandwich.subscription;

public interface SubscriberRepository {
    Subscriber find(SubscriberId subscriberId);
    void save(Subscriber subscriber);
}
