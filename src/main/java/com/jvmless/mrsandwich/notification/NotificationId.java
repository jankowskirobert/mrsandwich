package com.jvmless.mrsandwich.notification;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class NotificationId {
    private String id;

    public NotificationId() {
    }

    public static NotificationId random() {
        return new NotificationId(UUID.randomUUID().toString());
    }
}
