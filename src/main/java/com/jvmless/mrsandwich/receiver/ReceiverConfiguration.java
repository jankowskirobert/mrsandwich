package com.jvmless.mrsandwich.receiver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ReceiverConfiguration {

    @Bean
    ReceiverRepository receiverRepository() {
        return new ReceiverRepositoryInMemoryAdapter();
    }
}
