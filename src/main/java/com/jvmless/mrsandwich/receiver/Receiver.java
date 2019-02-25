package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.Location;
import com.jvmless.mrsandwich.message.TargetId;
import com.jvmless.mrsandwich.notification.VendorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
To handle only clients that have location not empty or null
 */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Document(collection = "receivers")
public class Receiver {
    @Id
    private String id;
    private String fcmRegistrationId;
    private TargetId targetId;
    private VendorId vendorId;
    private Availability availability;

    public static Receiver map(ReceiverDto receiverDto) {
        return null;
    }
}
