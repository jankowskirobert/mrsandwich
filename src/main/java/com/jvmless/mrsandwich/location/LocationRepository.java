package com.jvmless.mrsandwich.location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {
    Location save(Location location);
    List<Location> findBySellerId(String sellerId);
    Optional<Location> findById(LocationId id);
}
