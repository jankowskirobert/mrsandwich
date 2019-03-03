package com.jvmless.mrsandwich.location;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LocationRepositoryInMemory implements LocationRepository {

    private Map<LocationId, Location> inMemoryRepository = new ConcurrentHashMap<>();


    @Override
    public Location save(Location location) {
        return inMemoryRepository.put(location.getLocationName(), location);
    }

    @Override
    public List<Location> findBySellerId(String sellerId) {
        return null;
    }

    @Override
    public Optional<Location> findById(LocationId id) {
        return Optional.ofNullable(inMemoryRepository.get(id));
    }
}
