package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.mqadapters.MQReceiverAdapterDummy;
import com.jvmless.mrsandwich.client.mqadapters.MQSenderAdapterDummy;
import com.jvmless.mrsandwich.client.mqadapters.MQSenderSpringEventAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.management.*;

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
    public ClientFacade clientDevFacade(ClientRepository clientRepository, MQSenderPort mqSenderPort) {
        log.info("[DEVELOPER MODE] Client facade");
        return new ClientFacade(clientRepository, mqSenderPort);
    }

    @Bean
    public MQSenderPort dummyMqSender(ApplicationEventPublisher applicationEventPublisher) {
        log.info("[DEVELOPER MODE] Client dummy MQ sender");
        return new MQSenderSpringEventAdapter(applicationEventPublisher);
    }

    @Bean
    public BackstageClientFacade backstageClientFacade(ClientRepository clientRepository) {
        return new BackstageClientFacade(clientRepository);
    }

    @Bean
    public MQReceiverPort mqReceiverPort(ClientFacade clientFacade, MBeanServer mBeanServer) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MQReceiverAdapterDummy mqReceiverAdapterDummy = new MQReceiverAdapterDummy(clientFacade);
        StandardMBean mbean = new StandardMBean(mqReceiverAdapterDummy, MQReceiverPort.class);
        ObjectName name = new ObjectName("MQReceiverDummy:type=JMX,name=MQReceiverDummyPort");
        mBeanServer.registerMBean(mbean, name);
        return mqReceiverAdapterDummy;
    }
}
