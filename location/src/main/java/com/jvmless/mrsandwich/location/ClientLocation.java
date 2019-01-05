package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;

public class ClientLocation {

    private Double longitude;
    private Double latitude;
    private Boolean setManuallyByClient;
    private Address address;

    public static ClientLocation as(CurrentClientLocation currentClientLocation) {
        return null;
    }
}
