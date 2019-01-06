package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.location.dto.CurrentClientLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class TestLocationFacade {

    private LocationFacade locationFacade;
    private ClientLocationRepository clientLocationRepository;

    @Before
    public void setUp() {
        clientLocationRepository = new ClientLocationRepositoryInMemory();
        locationFacade = new LocationFacade(clientLocationRepository);
    }

    @Test
    public void shouldRegisterEmptyClient_shouldHaveEmptyLocationData_unableToLocate(){
        IncomingClient incomingClient = new IncomingClient("TEST1", "New client registered");
        Client client = Client.from(incomingClient);
        Assert.assertFalse(client.isAbleToLocate());
    }
    @Test
    public void shouldChangeClientLocation_customClientLocation(){
        IncomingClient incomingClient = new IncomingClient("TEST1", "New client registered");
        locationFacade.addClient(incomingClient);
        CurrentClientLocation currentClientLocation = new CurrentClientLocation();
        currentClientLocation.id("TEST1");
        currentClientLocation.custom(true);
        currentClientLocation.address(new Address());
        locationFacade.modifyClientLocation(currentClientLocation);
    }

}
