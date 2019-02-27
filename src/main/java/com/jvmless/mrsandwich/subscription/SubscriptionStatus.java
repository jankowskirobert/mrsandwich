package com.jvmless.mrsandwich.subscription;

public enum SubscriptionStatus {

    ACTIVATED, //send notification
    DEACTIVATED, //cannot send notification
    REMOVED //need subscribe again - unable to see
}
