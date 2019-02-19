package com.jvmless.mrsandwich.receiver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"prod", "stage"})
public class ProductionReceiverConfiguration {

    @Bean
    ReceiverRepository receiverRepository(MongoReceiverRepository mongoReceiverRepository) {
        return new MongoReceiverRepositoryAdapter(mongoReceiverRepository);
    }
}
