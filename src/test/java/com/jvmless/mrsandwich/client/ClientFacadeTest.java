package com.jvmless.mrsandwich.client;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ClientFacadeTest {
    @Mock
    ClientRepository clientRepository;

    ClientFacade clientFacade;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clientFacade = ClientFacade.of(clientRepository);
    }

    @Test(expected = ClientRegisterException.class)
    public void testRegisterClient() {
        RegisterClientDto clientDto = new RegisterClientDto("clientId");
        when(clientRepository.save(Client.by(clientDto))).thenThrow(new RuntimeException("Id already in database"));
        clientFacade.registerClient(clientDto);
    }

    @Test
    public void testDisableClient() throws Exception {
        clientFacade.disableClient(new DisableClientDto("clientId"));
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme