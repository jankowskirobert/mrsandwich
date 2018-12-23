package com.jvmless.mrsandwich.client.api;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MQSenderDummy implements MQSender {

    @Override
    public void registerClientMessage(RegisterClientDto dto) {
        log.info("[Dummy MQ] client register: {}", dto.getClientId());
    }
}
