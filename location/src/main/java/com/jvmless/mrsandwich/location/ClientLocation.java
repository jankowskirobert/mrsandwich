package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;
import lombok.Data;

@Data
public class ClientLocation {

    private Double longitude;
    private Double latitude;
    private Boolean setManuallyByClient;
    private Address address;

    public static ClientLocation empty() {
        return new ClientLocation();
    }

    public static ClientLocation as(CurrentClientLocation currentClientLocation) {
        return null;
    }

    public boolean isEmpty(){
        if(address == null || longitude == null || latitude == null) {
            return true;
        }
        return false;
    }

    public boolean isCorrect() {
        return false;
    }
}
