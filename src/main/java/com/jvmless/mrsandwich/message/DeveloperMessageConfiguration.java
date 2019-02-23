package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.seller.SellerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DeveloperMessageConfiguration {
    @Bean
    MessageRepository messageRepository() {
        return new MessageRepositoryInMemoryAdapter();
    }

    @Bean
    MessageFacade messageFacade(MessageRepository messageRepository, SellerRepository sellerRepository) {
        return new MessageFacade(messageRepository, sellerRepository);
    }
}
