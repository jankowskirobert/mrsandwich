package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.client.events.NewClientRegistered;
import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
public class SpringEventsMqSenderAdapter implements MQSender {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringEventsMqSenderAdapter(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void newSellerregistrationMessage(SellerRegisterDto sellerDto) {
        log.info("New Seller Published");
        applicationEventPublisher.publishEvent(sellerDto);
    }
}
