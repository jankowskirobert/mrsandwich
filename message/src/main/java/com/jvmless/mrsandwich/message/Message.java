package com.jvmless.mrsandwich.message;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@Data
public class Message {
    private MessageId messageId;
    private String messageBody;
    private SellerId owner;
    private LocalDateTime added;
    private MessageStatus messageStatus;
}
