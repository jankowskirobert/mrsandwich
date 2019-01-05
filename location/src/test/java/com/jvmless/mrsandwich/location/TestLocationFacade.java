package com.jvmless.mrsandwich.location;

import org.junit.Assert;
import org.junit.Test;

public class TestLocationFacade {

    @Test
    public void shouldRegisterEmptyClient_shouldHaveEmptyLocationData_unableToLocate(){
        IncomingClient incomingClient = new IncomingClient("TEST1", "New client registered");
        Client client = Client.from(incomingClient);
        Assert.assertFalse(client.isAbleToLocate());
    }

}
