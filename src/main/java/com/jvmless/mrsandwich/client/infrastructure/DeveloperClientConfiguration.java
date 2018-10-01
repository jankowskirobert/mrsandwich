package com.jvmless.mrsandwich.client.infrastructure;

import com.jvmless.mrsandwich.client.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@Slf4j
class DeveloperClientConfiguration {

    @Bean
    public ClientRepository developerClientRepository() {
        log.info("[DEVELOPER MODE] Client repository in memory DB");
        return new ClientRepositoryInMemory();
    }
}
