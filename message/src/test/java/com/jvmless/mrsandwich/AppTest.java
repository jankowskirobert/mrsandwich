package com.jvmless.mrsandwich;

import static org.junit.Assert.assertTrue;

import com.jvmless.mrsandwich.message.Client;
import com.jvmless.mrsandwich.message.ClientRepository;
import com.jvmless.mrsandwich.message.Location;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ClientRepository clientRepository;

    @Before
    public void setUp() {
        Client client = Client.of("ID", "FCM", Location.of(2.2, 2.3));
        clientRepository.save(client);

    }

    @Test
    public void shouldRegisterMessage() {


//        MessageBody messageBody = MessageBody.of();
//        Message message = Message.with().body()

    }
}
