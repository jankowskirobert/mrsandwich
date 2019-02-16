package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientLocation {

    private Double longitude;
    private Double latitude;
    private Boolean setManuallyByClient;
    private Address address;

    public static ClientLocation empty() {
        return new ClientLocation();
    }

    public static ClientLocation as(CurrentClientLocation currentClientLocation) {
        return new ClientLocation(
                currentClientLocation.longitude(),
                currentClientLocation.latitude(),
                currentClientLocation.custom(),
                currentClientLocation.address()
        );
    }

    public boolean isEmpty() {
        if (address == null || longitude == null || latitude == null) {
            return true;
        }
        return false;
    }

    public boolean isCorrect() {
        return false;
    }
}
