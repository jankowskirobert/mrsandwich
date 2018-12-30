package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MQSenderAdapterDummy implements MQSenderAdapter {

    @Override
    public void registerClientMessage(RegisterClientDto dto) {
        log.info("[Dummy MQ] client register: {}", dto.getClientId());
    }
}
