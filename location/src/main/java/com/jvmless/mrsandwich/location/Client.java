package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Client {

    private ClientLocation clientLocation;

    public static Client from(IncomingClient incomingClient) {
        return null;
    }

    public void changeCurrentLocation(CurrentClientLocation currentClientLocation) {
        if(isIncorrectLocation(currentClientLocation)){
            throw new ClientLocationChangeException();
        }
        clientLocation = ClientLocation.as(currentClientLocation);

    }

    private boolean isIncorrectLocation(CurrentClientLocation currentClientLocation) {
        return false;
    }
}
