package com.jvmless.mrsandwich.location;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class LocationId {
    private String id;
}
