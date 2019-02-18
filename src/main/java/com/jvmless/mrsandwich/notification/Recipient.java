package com.jvmless.mrsandwich.notification;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipient {
    private String receiverId;
    private String fcmKey;
}
