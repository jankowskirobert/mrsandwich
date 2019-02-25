package com.jvmless.mrsandwich.seller;

import java.util.List;

public class Subscriber {
    private SubscriberId subscriberId;
    private List<Location> location;
    private SubscriptionStatus subscriptionStatus;

    public void activate() {
        subscriptionStatus = SubscriptionStatus.ACTIVATED;
    }

    public boolean activated() {
        return subscriptionStatus.equals(SubscriptionStatus.ACTIVATED);
    }

    public void deactivate() {
        subscriptionStatus = SubscriptionStatus.DEACTIVATED;

    }

    public boolean isRemoved() {
        return subscriptionStatus.equals(SubscriptionStatus.REMOVED);
    }
}
