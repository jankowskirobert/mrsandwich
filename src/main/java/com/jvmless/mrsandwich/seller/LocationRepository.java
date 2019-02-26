package com.jvmless.mrsandwich.seller;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {
    List<Location> findBySellerId(String sellerId);
    Optional<Location> findById(String id);
}
