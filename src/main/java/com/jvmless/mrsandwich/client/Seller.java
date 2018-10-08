package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.exceptions.SellerDeactivateException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "seller")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Seller {
    private String sellerId;
    private SellerStatus sellerStatus;
    private LocalDateTime observationStart;
    private LocalDateTime observationEnd;

    public static Seller of(String sellerId) {
        return new Seller(sellerId, SellerStatus.ACTIVE, LocalDateTime.now(), null);
    }

    public void active() {
        if(this.observationStart != null) {
            throw new SellerDeactivateException("Seller already started");
        }
        this.observationEnd = null;
        this.sellerStatus = SellerStatus.ACTIVE;
        this.observationStart = LocalDateTime.now();
    }

    public void deactivate() {
        if(this.observationStart == null) {
            throw new SellerDeactivateException("Seller never started");
        }
        this.observationEnd = LocalDateTime.now();
        this.sellerStatus = SellerStatus.DEACTIVATED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(sellerId, seller.sellerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId);
    }
}
