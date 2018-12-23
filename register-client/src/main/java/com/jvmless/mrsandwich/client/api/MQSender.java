package com.jvmless.mrsandwich.client.api;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;

public interface MQSender {
    void registerClientMessage(RegisterClientDto dto);
}
