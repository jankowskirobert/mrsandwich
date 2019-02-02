package com.jvmless.mrsandwich.client.mqadapters;

import com.jvmless.mrsandwich.client.MQSenderPort;
import com.jvmless.mrsandwich.client.dto.AddSellerDto;
import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.MQException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MQSenderAdapterDummy implements MQSenderPort {

    @Override
    public void registerClientMessage(RegisterClientDto dto) {
        log.info("[Dummy MQ] client register: {}", dto.getClientId());
    }

    @Override
    public void clientObserveSellerMessage(AddSellerDto dto) throws MQException {
        log.info("[Dummy MQ] client observe new notificationSender: {}", dto.getClientId());
    }

    @Override
    public void disableClientMessage(DisableClientDto dto) {
        log.info("[Dummy MQ] client disabled: {}", dto.getClientId());
    }
}
