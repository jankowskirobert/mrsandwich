package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.client.ClientRepositoryInMemory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.*;

@Profile("dev")
@Configuration
@Slf4j
class DeveloperClientConfiguration {

    @Bean
    public ClientRepository clientRepository() {
        log.info("[DEVELOPER MODE] Client repository in memory DB");
        return new ClientRepositoryInMemory();
    }

    @Bean
    public ClientFacade clientDevFacade(ClientRepository clientRepository) {
        log.info("[DEVELOPER MODE] Client facade");
        return new ClientFacade(clientRepository);
    }
}
