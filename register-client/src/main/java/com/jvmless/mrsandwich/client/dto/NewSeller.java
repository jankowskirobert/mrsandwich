package com.jvmless.mrsandwich.client.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvmless.mrsandwich.client.dto.mq.NewSellerEventBody;
import com.jvmless.mrsandwich.client.exceptions.MQException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data
@AllArgsConstructor
public class NewSeller {
    private String sellerId;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static NewSeller dispatchJson(String jsonMessage) {
        try {
            NewSellerEventBody eventBody = objectMapper.readValue(jsonMessage, NewSellerEventBody.class);
            return new NewSeller(eventBody.getSellerId());
        } catch (IOException ex){
            throw new MQException("Cannot parse new seller registration event body", ex);
        }
    }
}
