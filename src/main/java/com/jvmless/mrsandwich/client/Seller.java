package com.jvmless.mrsandwich.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "client_seller")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Seller {
    @Id
    private String sellerId;
    private LocalDateTime sellerObserveStart;

    public static Seller of(String sellerId) {
        return new Seller(sellerId, null);
    }

    public void markAsObserved() {
        this.sellerObserveStart = LocalDateTime.now();
    }
}
