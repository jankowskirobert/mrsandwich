package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.Location;
import com.jvmless.mrsandwich.message.TargetId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Document(collection = "receivers")
public class Receiver {
    @Id
    private String id;
    private String fcmRegistrationId;
    private Location location;
    private TargetId targetId;
    private Availability availability;

    public static Receiver map(ReceiverDto receiverDto) {
        return null;
    }
}
