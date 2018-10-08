package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.client.ClientRepositoryMongoAdapter;
import com.jvmless.mrsandwich.client.ClientRepositoryMongoDb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("stage")
@Configuration
@EnableMongoRepositories
@Slf4j
class ClientConfiguration {

    @Bean
    public ClientRepository stageClientRepository(ClientRepositoryMongoDb clientRepositoryMongoDb) {
        log.info("[STAGE MODE] Client repository MongoDB");
        return new ClientRepositoryMongoAdapter(clientRepositoryMongoDb);
    }

    @Bean
    public ClientFacade clientStageFacade(ClientRepository clientRepository) {
        log.info("[STAGE MODE] Client facade");
        return ClientFacade.of(clientRepository);
    }
}
