package com.jvmless.mrsandwich.subscription;

import lombok.Data;

@Data
public class SubscribeToSeller {
    private String subscriptionId;
    private String locationId;
    private String clientId;
    private String sellerId;
}
