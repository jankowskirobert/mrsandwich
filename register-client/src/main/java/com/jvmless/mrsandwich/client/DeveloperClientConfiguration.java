package com.jvmless.mrsandwich.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
    public ClientFacade clientDevFacade(ClientRepository clientRepository, MQSenderAdapter mqSenderAdapter) {
        log.info("[DEVELOPER MODE] Client facade");
        return new ClientFacade(clientRepository, mqSenderAdapter);
    }

    @Bean
    public MQSenderAdapter dummyMqSender() {
        log.info("[DEVELOPER MODE] Client dummy MQ sender");
        return new MQSenderAdapterDummy();
    }

    @Bean
    public BackstageClientFacade backstageClientFacade(ClientRepository clientRepository) {
        return new BackstageClientFacade(clientRepository);
    }

    @Bean
    public MQReceiverPort mqReceiverPort(ClientFacade clientFacade) {
        return new MQReceiverPortDummy(clientFacade);
    }
}
