package com.jvmless.mrsandwich.client;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Accessors(fluent = true)
class ClientId {
    private String id;

    public static ClientId random() {
        return new ClientId(UUID.randomUUID().toString());
    }
}