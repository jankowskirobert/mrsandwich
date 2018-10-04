package com.jvmless.mrsandwich.seller;

import java.util.Optional;

public interface SellerRepository {
    Seller save(Seller by);

    Optional<Seller> find(String sellerId);
}
