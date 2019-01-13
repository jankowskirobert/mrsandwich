package com.jvmless.mrsandwich;

import com.jvmless.mrsandwich.message.*;
import com.jvmless.mrsandwich.client.Availability;
import com.jvmless.mrsandwich.client.Client;
import com.jvmless.mrsandwich.client.ClientRepository;
import com.jvmless.mrsandwich.client.ClientRepositoryInMemoryAdapter;
import com.jvmless.mrsandwich.notification.*;
import com.jvmless.mrsandwich.notification.commands.NotifyClients;
import org.junit.Assert;
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
    private PushNotificationAdapter pushNotificationAdapter = new PushNotificationAdapterDummy();
    private NotificationSenderRepository notificationSenderRepository = new NotificationSenderRepositoryInMemory();
    private static final String NOTIFICATION_EXIST = "EXIST-NOTIFICATION";

    @Before
    public void setUp() {
        Client client = Client.of("ID", "FCM", Location.of(2.2, 2.3), TargetId.of("TARGET-LOCATION-ID"), new Availability());
        clientRepository.save(client);

        Message messageForExistNotification = createBasicEnabledMessage(MessageId.of("MESSAGE-0"), NotificationSenderId.of("SELLER-1"));
        Notification notification = new Notification(
                NotificationId.of(NOTIFICATION_EXIST),
                new Client(),
                new NotificationSender(NotificationSenderId.of("SELLER-1")),
                messageForExistNotification,
                NotificationStatus.ENABLED
        );
        notificationRepository.save(notification);

        MessageId messageId = MessageId.of("MESSAGE-1");
        NotificationSenderId senderId = NotificationSenderId.of("SELLER-1");
        notificationSenderRepository.save(new NotificationSender(senderId));
        Message helloWorld = createBasicEnabledMessage(messageId, senderId);
        messageRepository.save(helloWorld);
    }

    private Message createBasicEnabledMessage(MessageId messageId, NotificationSenderId senderId) {
        return Message.of(
                messageId,
                "HELLO WORLD",
                senderId,
                LocalDateTime.now(),
                MessageStatus.ENABLED
        );
    }

    @Test
    public void shouldRegisterMessage() {
        NotificationId notificationId = NotificationId.of(UUID.randomUUID().toString());
        MessageId messageId = MessageId.of("MESSAGE-1");
        NotifyClients notifyClients = NotifyClients.by(
                notificationId,
                NotificationSenderId.of("SELLER-1"),
                messageId,
                LocalDateTime.now().plusMinutes(3),
                TargetId.of("TARGET-LOCATION-ID")
        );
        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(
                notificationRepository,
                messageRepository,
                clientRepository,
                notificationSenderRepository,
                pushNotificationAdapter
        );
        notifyClientsHandler.handle(notifyClients);
        Notification notification = notificationRepository.findBy(notificationId);
        Assert.assertNotNull(notification);
        Assert.assertTrue(notification.getStatus().equals(NotificationStatus.ENABLED));
    }

    @Test(expected = NotificationAlreadyExistException.class)
    public void shouldNotHandleNotification_idInDatabase() {
        NotificationId notificationId = NotificationId.of(NOTIFICATION_EXIST);
        MessageId messageId = MessageId.of("MESSAGE-1");
        NotifyClients notifyClients = NotifyClients.by(
                notificationId,
                NotificationSenderId.of("SELLER-1"),
                messageId,
                LocalDateTime.now().plusMinutes(3),
                TargetId.of("TARGET-LOCATION-ID")
        );
        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(
                notificationRepository,
                messageRepository,
                clientRepository,
                notificationSenderRepository,
                pushNotificationAdapter
        );
        notifyClientsHandler.handle(notifyClients);
    }
}
