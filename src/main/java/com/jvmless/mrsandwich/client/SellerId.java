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
public class SellerId {
    private String id;

    public static SellerId random() {
        return new SellerId(UUID.randomUUID().toString());
    }
}
