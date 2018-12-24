package com.jvmless.mrsandwich.client.api;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitSender implements MQSender {

    private final RabbitTemplate template;

    public RabbitSender(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void registerClientMessage(RegisterClientDto dto) {
        template.convertAndSend("register-client", "new-client-register", dto.getClientId());
    }
}
