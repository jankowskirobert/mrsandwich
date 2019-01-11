package com.jvmless.mrsandwich.message;

import lombok.Data;

@Data
public class AddNewMessage {
    public String sellerId;
    public String messageBody;
}
