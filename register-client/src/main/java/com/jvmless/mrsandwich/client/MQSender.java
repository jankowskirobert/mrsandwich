package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.MQException;

interface MQSender {
    void registerClientMessage(RegisterClientDto dto) throws MQException;
}
