package com.jvmless.mrsandwich.location.dto;

import com.jvmless.mrsandwich.location.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
public class CurrentClientLocation {
    private String id;
    private boolean custom;
    private Address address;
    private double longitude;
    private double latitude;
}
