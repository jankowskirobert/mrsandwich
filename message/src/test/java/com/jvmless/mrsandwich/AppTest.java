package com.jvmless.mrsandwich;

import static org.junit.Assert.assertTrue;

import com.jvmless.mrsandwich.message.*;
import com.jvmless.mrsandwich.message.client.Client;
import com.jvmless.mrsandwich.message.client.ClientId;
import com.jvmless.mrsandwich.message.client.ClientRepository;
import com.jvmless.mrsandwich.message.client.ClientRepositoryInMemoryAdapter;
import com.jvmless.mrsandwich.message.commands.NotifyClients;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ClientRepository clientRepository = new ClientRepositoryInMemoryAdapter();
    private NotificationRepository notificationRepository = new NotificationRepositoryInMemoryAdapter();
    private static final String NOTIFICATION_EXIST = "EXIST-NOTIFICATION";

    @Before
    public void setUp() {
        Client client = Client.of("ID", "FCM", Location.of(2.2, 2.3));
        clientRepository.save(client);

        Notification notification = new Notification(NotificationId.of(NOTIFICATION_EXIST), ClientId.of("Dummy"));
        notificationRepository.save(notification);
    }

    @Test
    public void shouldRegisterMessage() {
        NotificationId notificationId = NotificationId.of(UUID.randomUUID().toString());
        NotifyClients notifyClients = NotifyClients.by(
                notificationId,
                SellerId.of("SANDWICH-SELLER-1"),
                "Will be in 3 minutes",
                LocalDateTime.now().plusMinutes(3),
                TargetId.of("PLACE-1"));
        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(notificationRepository);
        notifyClientsHandler.handle(notifyClients);
//        MessageBody messageBody = MessageBody.of();
//        Message message = Message.with().body()

    }

    @Test(expected = NotificationAlreadyExistException.class)
    public void shouldNotHandleNotification_idInDatabase() {
        NotificationId notificationId = NotificationId.of(NOTIFICATION_EXIST);
        NotifyClients notifyClients = NotifyClients.by(
                notificationId,
                SellerId.of("SANDWICH-SELLER-1"),
                "Will be in 3 minutes",
                LocalDateTime.now().plusMinutes(3),
                TargetId.of("PLACE-1"));
        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(notificationRepository);
        notifyClientsHandler.handle(notifyClients);
//        MessageBody messageBody = MessageBody.of();
//        Message message = Message.with().body()

    }
}
