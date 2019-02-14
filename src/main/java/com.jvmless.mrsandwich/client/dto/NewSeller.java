package com.jvmless.mrsandwich.client.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jvmless.mrsandwich.client.dto.mq.NewSellerEventBody;
import com.jvmless.mrsandwich.client.exceptions.MQException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.io.IOException;

@Data
@AllArgsConstructor
public class NewSeller {
    @NonNull
    private String sellerId;

    public static NewSeller dispatchJson(String jsonMessage) throws MQException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            NewSellerEventBody eventBody = objectMapper.readValue(jsonMessage, NewSellerEventBody.class);
            return new NewSeller(eventBody.getSellerId());
        } catch (IOException | NullPointerException ex){
            throw new MQException("Cannot parse new vendor registration event body", ex);
        }
    }
}
