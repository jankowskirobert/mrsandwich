package com.jvmless.mrsandwich.location;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"stage", "prod"})
@Configuration
class LocationConfiguration {

    @Bean
    public LocationFacade locationFacade(ClientLocationRepository clientLocationRepository) {
        return new LocationFacade(clientLocationRepository);
    }

    @Bean
    public ClientLocationRepository mognoDbLocationRepository(MongoLocationRepository mongoLocationRepository) {
        return new MongoLocationRepositoryAdapter(mongoLocationRepository);
    }

}
