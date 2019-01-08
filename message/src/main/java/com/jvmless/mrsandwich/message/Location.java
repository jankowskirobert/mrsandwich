package com.jvmless.mrsandwich.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(staticName = "of")
@Data
public class Location {
    private Double longitude;
    private Double latitude;
}
