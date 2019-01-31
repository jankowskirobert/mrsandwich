package com.jvmless.mrsandwich.seller.dto.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvmless.mrsandwich.seller.exceptions.MQException;
import lombok.AllArgsConstructor;
import lombok.Data;

public class NewSellerRegistrationEvent implements MQEvent {

    EventBody eventBody;
    ObjectMapper objectMapper;

    public NewSellerRegistrationEvent(String id) {
        this.objectMapper = new ObjectMapper();
        this.eventBody = new EventBody(id, "Created new notificationSender!");
    }

    @Override
    public String routingKey() {
        return "";
    }

    @Override
    public String exchange() {
        return "";
    }

    @Override
    public String message() {
        try {
            return objectMapper.writeValueAsString(eventBody);
        } catch (JsonProcessingException e) {
            throw new MQException();
        }
    }
    @Data
    @AllArgsConstructor
    static class EventBody {

        String newSellerId;
        String description;

    }
}
