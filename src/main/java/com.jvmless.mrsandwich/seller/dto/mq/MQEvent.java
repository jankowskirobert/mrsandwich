package com.jvmless.mrsandwich.seller.dto.mq;

import com.jvmless.mrsandwich.seller.exceptions.MQException;

public interface MQEvent {
    String routingKey();
    String exchange();
    String message() throws MQException;
}
