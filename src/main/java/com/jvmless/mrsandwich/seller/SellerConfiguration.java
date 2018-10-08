package com.jvmless.mrsandwich.seller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("stage")
@Configuration
@EnableMongoRepositories
@Slf4j
class SellerConfiguration {


    @Bean
    public SellerRepository stageClientRepository(SellerRepositoryMongoDb sellerRepositoryMongoDb) {
        log.info("[STAGE MODE] Seller repository MongoDB");
        return new SellerRepositoryMongoAdapter(sellerRepositoryMongoDb);
    }

    @Bean
    public SellerFacade clientFacade(SellerRepository sellerRepository) {
        log.info("[ALL MODE] Seller facade");
        return SellerFacade.of(sellerRepository);
    }
}