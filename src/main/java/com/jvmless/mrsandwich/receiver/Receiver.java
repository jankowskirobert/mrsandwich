package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.Location;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Receiver {
    private String clientId;
    private String fcmRegistrationId;
    private Location location;
    private TargetId targetId;
    private Availability availability;

    public static Receiver map(ReceiverDto receiverDto) {
        return null;
    }
}
