package com.jvmless.mrsandwich.client;

import java.time.LocalDateTime;


public class Seller {
    private String sellerId;
    private LocalDateTime sellerObserveStart;

    public void markAsObserved() {
        this.sellerObserveStart = LocalDateTime.now();
    }
}
