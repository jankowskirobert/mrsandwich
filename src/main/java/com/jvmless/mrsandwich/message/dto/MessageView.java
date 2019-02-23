package com.jvmless.mrsandwich.message.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MessageView {
    private String messageId;
    private String messageBody;
    private LocalDateTime added;
    private String messageStatus;
}
