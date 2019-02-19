package com.jvmless.mrsandwich.message;

import com.jvmless.mrsandwich.notification.VendorId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@Data
@Document(collection = "messages")
public class Message {
    @Id
    private MessageId messageId;
    private String messageBody;
    private VendorId owner;
    private LocalDateTime added;
    private MessageStatus messageStatus;
}
