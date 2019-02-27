package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.notification.application.NotifyClientsHandler;
import com.jvmless.mrsandwich.notification.*;
import com.jvmless.mrsandwich.message.*;
import com.jvmless.mrsandwich.notification.application.NotifyClients;
import com.jvmless.mrsandwich.notification.DummyToConsoleNotificationSenderAdapter;
import com.jvmless.mrsandwich.notification.NotificationRepositoryInMemoryAdapter;
import com.jvmless.mrsandwich.notification.NotificationSenderRepositoryInMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
//public class AppTest {
//
//    private ReceiverRepository receiverRepository = new ReceiverRepositoryInMemoryAdapter();
//    private MessageRepository messageRepository = new MessageRepositoryInMemoryAdapter();
//    private NotificationRepository notificationRepository = new NotificationRepositoryInMemoryAdapter();
//    private NotificationSenderPort pushNotificationAdapter = new DummyToConsoleNotificationSenderAdapter();
//    private NotificationSenderRepository notificationSenderRepository = new NotificationSenderRepositoryInMemory();
//    private static final String NOTIFICATION_EXIST = "EXIST-NOTIFICATION";
//
//    @Before
//    public void setUp() {
//        Receiver receiver = Receiver.of("ID", "FCM", Location.of(2.2, 2.3), TargetId.of("TARGET-LOCATION-ID"), new Availability());
//        receiverRepository.save(receiver);
//
//        Message messageForExistNotification = createBasicEnabledMessage(MessageId.of("MESSAGE-0"), VendorId.of("SELLER-1"));
//        Notification notification = new Notification(
//                NotificationId.of(NOTIFICATION_EXIST),
//                new Vendor(VendorId.of("SELLER-1")),
//                new MessageDetails(messageForExistNotification.getMessageBody())
//        );
//        notificationRepository.save(notification);
//
//        MessageId messageId = MessageId.of("MESSAGE-1");
//        VendorId senderId = VendorId.of("SELLER-1");
//        notificationSenderRepository.save(new Vendor(senderId));
//        Message helloWorld = createBasicEnabledMessage(messageId, senderId);
//        messageRepository.save(helloWorld);
//    }
//
//    private Message createBasicEnabledMessage(MessageId messageId, VendorId senderId) {
//        return Message.of(
//                messageId,
//                "HELLO WORLD",
//                senderId,
//                LocalDateTime.now(),
//                MessageStatus.ENABLED
//        );
//    }
//
//    @Test
//    public void shouldRegisterMessage() {
//        NotificationId notificationId = NotificationId.of(UUID.randomUUID().toString());
//        MessageId messageId = MessageId.of("MESSAGE-1");
//        NotifyClients notifyClients = NotifyClients.by(
//                notificationId,
//                VendorId.of("SELLER-1"),
//                messageId,
//                LocalDateTime.now().plusMinutes(3),
//                TargetId.of("TARGET-LOCATION-ID")
//        );
//        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(
//                notificationRepository,
//                messageRepository,
//                receiverRepository,
//                notificationSenderRepository,
//                pushNotificationAdapter
//        );
//        notifyClientsHandler.handle(notifyClients);
//        Optional<Notification> notification = notificationRepository.findBy(notificationId);
//        Assert.assertTrue(notification.isPresent());
//        Assert.assertTrue(notification.get().getStatus().equals(NotificationStatus.WAITING));
//    }
//
//    @Test(expected = NotificationAlreadyExistException.class)
//    public void shouldNotHandleNotification_idInDatabase() {
//        NotificationId notificationId = NotificationId.of(NOTIFICATION_EXIST);
//        MessageId messageId = MessageId.of("MESSAGE-1");
//        NotifyClients notifyClients = NotifyClients.by(
//                notificationId,
//                VendorId.of("SELLER-1"),
//                messageId,
//                LocalDateTime.now().plusMinutes(3),
//                TargetId.of("TARGET-LOCATION-ID")
//        );
//        NotifyClientsHandler notifyClientsHandler = new NotifyClientsHandler(
//                notificationRepository,
//                messageRepository,
//                receiverRepository,
//                notificationSenderRepository,
//                pushNotificationAdapter
//        );
//        notifyClientsHandler.handle(notifyClients);
//    }
//}
