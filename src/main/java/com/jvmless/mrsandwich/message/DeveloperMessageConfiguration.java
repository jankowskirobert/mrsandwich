package com.jvmless.mrsandwich.message;

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
    MessageFacade messageFacade(MessageRepository messageRepository) {
        return new MessageFacade(messageRepository);
    }
}
