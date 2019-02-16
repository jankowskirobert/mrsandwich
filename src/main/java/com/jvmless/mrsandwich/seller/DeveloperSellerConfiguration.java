package com.jvmless.mrsandwich.seller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@Slf4j
class DeveloperSellerConfiguration {


    @Bean
    public SellerRepository developerClientRepository() {
        log.info("[DEVELOPER MODE] Seller repository in memory DB");
        return new SellerRepositoryInMemory();
    }

    @Bean
    public SellerFacade clientFacade(SellerRepository sellerRepository) {
        log.info("[DEVELOPER MODE] Seller facade");
        return SellerFacade.of(sellerRepository);
    }
}