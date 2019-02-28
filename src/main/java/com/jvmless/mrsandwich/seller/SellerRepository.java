package com.jvmless.mrsandwich.seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {
    Seller save(Seller by);

    Optional<Seller> find(SellerId sellerId);

    List<Seller> findAllAvailableSellers();
}
