package com.jvmless.mrsandwich.client.mqadapters;

import com.jvmless.mrsandwich.client.MQSenderPort;
import com.jvmless.mrsandwich.client.dto.AddSellerDto;
import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.events.NewClientRegistered;
import com.jvmless.mrsandwich.client.exceptions.MQException;
import com.jvmless.mrsandwich.seller.MQSender;
import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
public class MQSenderSpringEventAdapter implements MQSenderPort {

    private final ApplicationEventPublisher publisher;

    public MQSenderSpringEventAdapter(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void registerClientMessage(RegisterClientDto dto) throws MQException {
        log.info("Sending new client registered event");
        publisher.publishEvent(new NewClientRegistered(dto.getClientId()));
    }

    @Override
    public void clientObserveSellerMessage(AddSellerDto dto) throws MQException {

    }

    @Override
    public void disableClientMessage(DisableClientDto dto) {

    }
}
