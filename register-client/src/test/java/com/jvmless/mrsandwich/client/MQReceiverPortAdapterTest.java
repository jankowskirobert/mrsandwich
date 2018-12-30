package com.jvmless.mrsandwich.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvmless.mrsandwich.client.dto.NewSeller;
import com.jvmless.mrsandwich.client.dto.mq.NewSellerEventBody;
import org.junit.Before;
import org.junit.Test;

public class MQReceiverPortAdapterTest {

    ClientRepository clientRepository = new ClientRepositoryInMemory();
    MQSenderAdapter mqSenderAdapter = new MQSenderAdapterDummy();
    ClientFacade clientFacade;
    MQReceiverPort mqReceiverPort;
    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        clientFacade = ClientFacade.of(clientRepository, mqSenderAdapter);
        mqReceiverPort = new MQReceiverPortDummy(clientFacade);
    }

    @Test
    public void shouldRegisterNewSeller() throws JsonProcessingException {
        NewSellerEventBody newSellerEventBody = new NewSellerEventBody("sellerId", "Seller Register");
        mqReceiverPort.newSellerRegistrationMessage(objectMapper.writeValueAsString(newSellerEventBody));
    }
}
