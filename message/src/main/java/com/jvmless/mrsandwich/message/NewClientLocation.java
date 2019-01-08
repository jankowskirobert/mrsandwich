package com.jvmless.mrsandwich.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.io.IOException;

@AllArgsConstructor
@Getter
public class NewClientLocation {
    @NonNull
    private String clientId;

    public static NewClientLocation fromEvent(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EventBody eventBody = objectMapper.readValue(message, EventBody.class);
            return new NewClientLocation(eventBody.clientId);
        } catch (IOException | NullPointerException ex) {
            throw new MQException("Cannot parse event", ex);
        }
    }
    public static class EventBody {
        private String clientId;
        private String description;
    }
}
