package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
@Document(collection = "locations")
public class Client {
    @Id
    private String id;
    private ClientLocation clientLocation;

    public static Client from(IncomingClient incomingClient) {
        return new Client(incomingClient.getId(), ClientLocation.empty());
    }

    public void changeCurrentLocation(CurrentClientLocation currentClientLocation) {
        if (isIncorrectLocation(currentClientLocation)) {
            throw new ClientLocationChangeException();
        }
        clientLocation = ClientLocation.as(currentClientLocation);

    }

    private boolean isIncorrectLocation(CurrentClientLocation currentClientLocation) {
        return ClientLocation.as(currentClientLocation).isEmpty() && ClientLocation.as(currentClientLocation).isCorrect();
    }

    public boolean isAbleToLocate() {
        return !clientLocation.isEmpty();
    }
}
