package com.jvmless.mrsandwich.location;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private LocationId locationName;
    private GeoPosition position;
    private Address address;

    public Location(LocationId locationName) {
        this.locationName = locationName;
    }
}
