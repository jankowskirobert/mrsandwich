package com.jvmless.mrsandwich.seller;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepositoryMongoDb extends MongoRepository<Seller, String> {

}
