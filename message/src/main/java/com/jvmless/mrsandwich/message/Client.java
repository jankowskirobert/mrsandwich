package com.jvmless.mrsandwich.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Client {
    private String id;
    private String fcmRegistrationId;
    private Location location;

}
