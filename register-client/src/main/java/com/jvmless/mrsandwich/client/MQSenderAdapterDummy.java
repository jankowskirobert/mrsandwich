package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.AddSellerDto;
import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.MQException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MQSenderAdapterDummy implements MQSenderAdapter {

    @Override
    public void registerClientMessage(RegisterClientDto dto) {
        log.info("[Dummy MQ] client register: {}", dto.getClientId());
    }

    @Override
    public void clientObserveSellerMessage(AddSellerDto dto) throws MQException {
        log.info("[Dummy MQ] client observe new seller: {}", dto.getClientId());
    }

    @Override
    public void disableClientMessage(DisableClientDto dto) {
        log.info("[Dummy MQ] client disabled: {}", dto.getClientId());
    }
}
