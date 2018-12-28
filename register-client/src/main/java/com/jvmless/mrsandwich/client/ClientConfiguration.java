package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.RabbitSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile({"stage", "prod"})
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
    public ClientFacade clientStageFacade(ClientRepository clientRepository, MQSender mqSender) {
        log.info("[STAGE MODE] Client facade");
        return ClientFacade.of(clientRepository, mqSender);
    }

    @Bean
    public MQSender mqSender(RabbitTemplate rabbitTemplate) {
        log.info("[STAGE MODE] Client RabbitMQ sender");
        return new RabbitSender(rabbitTemplate);
    }

    @Bean
    public BackstageClientFacade backstageClientFacade(ClientRepository clientRepository) {
        return new BackstageClientFacade(clientRepository);
    }

}
