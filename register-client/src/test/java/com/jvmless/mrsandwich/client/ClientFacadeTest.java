package com.jvmless.mrsandwich.client;


import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.ClientRegisterException;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

public class ClientFacadeTest {

    ClientRepository clientRepository = new ClientRepositoryInMemory();
    MQSenderAdapter mqSenderAdapter = new MQSenderAdapterDummy();
    ClientFacade clientFacade;

    @Before
    public void setUp() {
        clientFacade = ClientFacade.of(clientRepository, mqSenderAdapter);
    }

    @Test(expected = ClientRegisterException.class)
    public void shouldThrowExceptionIfClientWithGivenIdAlreadyExist() {
        String clientId = "ALREADY IN DB";
        RegisterClientDto initialClientDto = new RegisterClientDto(clientId);
        clientFacade.registerClient(initialClientDto);
        RegisterClientDto secondaryClientDto = new RegisterClientDto(clientId);
        clientFacade.registerClient(secondaryClientDto);
    }

    @Test
    public void testDisableClient() {
        ClientId clientId = ClientId.random();
        RegisterClientDto clientDto = new RegisterClientDto(clientId.id());
        clientFacade.registerClient(clientDto);
        DisableClientDto disableClientDto = new DisableClientDto(clientId.id());
        clientFacade.disableClient(disableClientDto);
        Optional<Client> after = clientRepository.findById(clientId);
        Assert.assertThat(after.get().isEnable(), Matchers.equalTo(false));
    }

    @Test
    public void testAddSellerToObserverList(){
        String clientId = UUID.randomUUID().toString();
        String sellerId = UUID.randomUUID().toString();
        Client client = Client.by(new RegisterClientDto(clientId));
        client.addSeller(sellerId);
    }

    @After
    public void cleanUp() {
        clientRepository.removeAll();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme