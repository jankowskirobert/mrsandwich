package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;

public class LocationFacade {

    private ClientLocationRepository clientLocationRepository;

    public LocationFacade(ClientLocationRepository clientLocationRepository) {
        this.clientLocationRepository = clientLocationRepository;
    }

    public void modifyClientLocation(CurrentClientLocation currentClientLocation) {
        clientLocationRepository.findOne(currentClientLocation.id()).ifPresent(
                x -> {
                    x.changeCurrentLocation(currentClientLocation);
                    clientLocationRepository.save(x);
                }
        );
    }

    public void addClient(IncomingClient incomingClient) {
        clientLocationRepository.save(Client.from(incomingClient));
    }
}
