package com.jvmless.mrsandwich;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class NotificationId {
    private String id;

    public static NotificationId random() {
        return new NotificationId(UUID.randomUUID().toString());
    }
}
