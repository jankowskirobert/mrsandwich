package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@Data
public class Message {
    private MessageId messageId;
    private String messageBody;
    private VendorId owner;
    private LocalDateTime added;
    private MessageStatus messageStatus;
}
