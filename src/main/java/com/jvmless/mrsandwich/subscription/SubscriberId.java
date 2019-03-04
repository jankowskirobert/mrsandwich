package com.jvmless.mrsandwich.subscription;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SubscriberId {
    private String id;

    protected static SubscriberId random() {
        return new SubscriberId(UUID.randomUUID().toString());
    }
}