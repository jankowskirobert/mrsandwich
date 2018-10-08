package com.jvmless.mrsandwich.seller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class SellerRepositoryInMemory implements SellerRepository {
    private Map<String, Seller> inMemoryDataBase = new ConcurrentHashMap<>();

    @Override
    public Seller save(Seller seller) {
        return inMemoryDataBase.put(seller.id(), seller);
    }

    @Override
    public Optional<Seller> find(String sellerId) {
        return Optional.ofNullable(inMemoryDataBase.get(sellerId));
    }

    @Override
    public List<Seller> findAllAvailableSellers() {
        return inMemoryDataBase.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
    }
}
