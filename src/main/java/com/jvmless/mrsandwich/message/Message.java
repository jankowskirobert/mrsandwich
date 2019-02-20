package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@Getter
@Document(collection = "messages")
@EqualsAndHashCode(of = "messageId")
public class Message {
    @Id
    private MessageId messageId;
    private String messageBody;
    private VendorId owner;
    private LocalDateTime added;
    private MessageStatus messageStatus;
}
