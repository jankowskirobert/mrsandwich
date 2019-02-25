package com.jvmless.mrsandwich.seller;

public enum SubscriptionStatus {

    ACTIVATED, //send notification
    DEACTIVATED, //cannot send notification
    REMOVED //need subscribe again - unable to see
}
