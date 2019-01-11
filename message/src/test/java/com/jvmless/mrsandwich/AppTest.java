package com.jvmless.mrsandwich;

import com.jvmless.mrsandwich.message.*;
import com.jvmless.mrsandwich.message.client.Client;
import com.jvmless.mrsandwich.message.client.ClientId;
import com.jvmless.mrsandwich.message.client.ClientRepository;
import com.jvmless.mrsandwich.message.client.ClientRepositoryInMemoryAdapter;
import com.jvmless.mrsandwich.message.notification.commands.NotifyClients;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ClientRepository clientRepository = new ClientRepositoryInMemoryAdapter();
    private MessageRepository messageRepository = new MessageRepositoryInMemoryAdapter();
    private NotificationRepository notificationRepository = new NotificationRepositoryInMemoryAdapter();
    private static final String NOTIFICATION_EXIST = "EXIST-NOTIFICATION";

    @Before
    public void setUp() {
        Client client = Client.of("ID", "FCM", Location.of(2.2, 2.3));
        clientRepository.save(client);

        Notification notification = new Notification(NotificationId.of(NOTIFICATION_EXIST), new Client(), new TargetArea(), new Seller(), MessageId.of("MESS-1"));
        notificationRepository.save(notification);

        MessageId messageId = MessageId.of("MESSAGE-1");
        messageRepository.save(Message.of(messageId, "Hello World", SellerId.of("SELLER-1"), LocalDateTime.now(), MessageStatus.ENABLED));
    }

    @Test
    public void shouldRegisterMessage() {
        NotificationId notificationId = NotificationId.of(UUID.randomUUID().toString());
        MessageId messageId = MessageId.of("MESSAGE-1");
        NotifyClients notifyClients = NotifyClients.by(
                notificationId,
                SellerId.of("SANDWICH-SELLER-1"),
                messageId,
                LocalDateTime.now().plusMinutes(3),
                TargetId.of("PLACE-1"));
        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(notificationRepository, messageRepository);
        notifyClientsHandler.handle(notifyClients);
    }

    @Test(expected = NotificationAlreadyExistException.class)
    public void shouldNotHandleNotification_idInDatabase() {
        NotificationId notificationId = NotificationId.of(NOTIFICATION_EXIST);
        MessageId messageId = MessageId.of("MESSAGE-1");
        NotifyClients notifyClients = NotifyClients.by(
                notificationId,
                SellerId.of("SANDWICH-SELLER-1"),
                messageId,
                LocalDateTime.now().plusMinutes(3),
                TargetId.of("PLACE-1"));
        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(notificationRepository, messageRepository);
        notifyClientsHandler.handle(notifyClients);

    }
}
