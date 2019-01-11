package com.jvmless.mrsandwich.message.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(staticName = "of")
@Data
public class ClientId {
    private String id;
}
