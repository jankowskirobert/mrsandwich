package com.jvmless.mrsandwich.seller;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface SellerRepository {
    Seller save(Seller by);

    Optional<Seller> find(String sellerId);

    List<Seller> findAllAvailableSellers();
}
