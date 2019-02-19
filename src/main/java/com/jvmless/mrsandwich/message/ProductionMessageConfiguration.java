package com.jvmless.mrsandwich.message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"prod", "stage"})
public class ProductionMessageConfiguration {

    @Bean
    public MessageRepository messageRepository(MongoMessageRepository mongoMessageRepository) {
        return new MongoMessageRepositoryAdapter(mongoMessageRepository);
    }

}
