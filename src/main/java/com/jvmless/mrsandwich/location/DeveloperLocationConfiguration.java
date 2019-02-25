package com.jvmless.mrsandwich.location;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
class DeveloperLocationConfiguration {

    @Bean
    public LocationFacade locationFacade(ClientLocationRepository clientLocationRepository) {
        return new LocationFacade(clientLocationRepository);
    }

    @Bean
    public MQReceiver mqReceiver(ClientLocationRepository clientLocationRepository) {
        return new MQReceiverSpringEventAdapter(clientLocationRepository);
    }

    @Bean
    public ClientLocationRepository inMemoryLocationRepository() {
        return new ClientLocationRepositoryInMemory();
    }

}
