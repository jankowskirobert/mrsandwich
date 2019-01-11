package com.jvmless.mrsandwich.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jvmless.mrsandwich.client.dto.mq.NewSellerEventBody;
import com.jvmless.mrsandwich.client.exceptions.MQException;
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
        NewSellerEventBody newSellerEventBody = new NewSellerEventBody("notificationSenderId", "Seller Register");
        mqReceiverPort.newSellerRegistrationMessage(objectMapper.writeValueAsString(newSellerEventBody));
    }

    @Test(expected = MQException.class)
    public void shouldNotRegisterNewSeller_wrongMessageFormat() {
        String message = "{\"ddd\":\"ddd\"}";
        mqReceiverPort.newSellerRegistrationMessage(message);
    }

    @Test(expected = MQException.class)
    public void shouldNotRegisterNewSeller_emptyMessage() {
        String message = "{}";
        mqReceiverPort.newSellerRegistrationMessage(message);
    }
}
