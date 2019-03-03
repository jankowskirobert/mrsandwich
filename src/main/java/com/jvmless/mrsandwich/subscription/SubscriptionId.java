package com.jvmless.mrsandwich.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SubscriptionId {
    private String id;

    protected static SubscriptionId random() {
        return new SubscriptionId(UUID.randomUUID().toString());
    }
}
