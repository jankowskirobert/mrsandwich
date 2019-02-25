package com.jvmless.mrsandwich.client.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewClientRegistered {
    private String id;
}
