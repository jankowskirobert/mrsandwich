package com.jvmless.mrsandwich.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
Event
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomingClient {
    private String id;
    private String description;
}
