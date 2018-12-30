package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.MQException;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

class RabbitSenderAdapter implements MQSenderAdapter {

    private final RabbitTemplate template;

    public RabbitSenderAdapter(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void registerClientMessage(RegisterClientDto dto) throws MQException {
        try {
            template.convertAndSend("register-client", "new-client-register", dto.getClientId());
        } catch (AmqpException exception) {
            throw new MQException("Cannot send client registration event", exception);
        }
    }
}
