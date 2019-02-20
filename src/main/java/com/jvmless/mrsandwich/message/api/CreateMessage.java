package com.jvmless.mrsandwich.message.api;

import com.jvmless.mrsandwich.message.MessageStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateMessage {
    @NotNull
    private String messageId;
    @NotNull
    private String vendorId;
    private MessageStatus messageStatus = MessageStatus.DISABLED;
    @NotEmpty
    @NotNull
    private String messageBody;
}
