package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.AddSellerDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.MQException;

public interface MQSenderAdapter {
    void registerClientMessage(RegisterClientDto dto) throws MQException;

    void clientObserveSellerMessage(AddSellerDto dto) throws MQException;
}
