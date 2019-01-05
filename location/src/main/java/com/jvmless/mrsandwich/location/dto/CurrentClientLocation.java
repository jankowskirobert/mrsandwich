package com.jvmless.mrsandwich.location.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data()
@Accessors(fluent = true)
public class CurrentClientLocation {
    private String id;
}
