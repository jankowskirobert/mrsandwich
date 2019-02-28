package com.jvmless.mrsandwich.seller;

import org.springframework.data.mongodb.repository.MongoRepository;

interface SellerRepositoryMongoDb extends MongoRepository<Seller, SellerId> {

}
