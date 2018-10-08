package com.jvmless.mrsandwich.seller;

import java.util.List;
import java.util.Optional;

class SellerRepositoryMongoAdapter implements SellerRepository {

    private SellerRepositoryMongoDb sellerRepositoryMongoDb;

    public SellerRepositoryMongoAdapter(SellerRepositoryMongoDb sellerRepositoryMongoDb) {
        this.sellerRepositoryMongoDb = sellerRepositoryMongoDb;
    }

    @Override
    public Seller save(Seller entity) {
        return sellerRepositoryMongoDb.save(entity);
    }

    @Override
    public Optional<Seller> find(String sellerId) {
        return sellerRepositoryMongoDb.findById(sellerId);
    }

    @Override
    public List<Seller> findAllAvailableSellers() {
        return sellerRepositoryMongoDb.findAll();
    }
}
