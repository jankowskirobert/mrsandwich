package com.jvmless.mrsandwich.notification;

import com.jvmless.mrsandwich.message.MessageRepository;
import com.jvmless.mrsandwich.notification.application.NotifyClientsHandler;
import com.jvmless.mrsandwich.receiver.ReceiverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"prod", "stage"})
@Slf4j
public class ProductionNotificationConfiguration {

    @Bean
    NotificationRepository notificationRepository() {
        return new NotificationRepositoryInMemoryAdapter();
    }

    @Bean
    NotificationSenderPort notificationSenderPort() {
        return new DummyToConsoleNotificationSenderAdapter();
    }

    @Bean
    NotificationSenderRepository notificationSenderRepository() {
        return new NotificationSenderRepositoryInMemory();
    }

    @Bean
    NotifyClientsHandler sendHandler(NotificationSenderPort notificationSenderPort, MessageRepository messageRepository, NotificationSenderRepository notificationSenderRepository, NotificationRepository notificationRepository, ReceiverRepository receiverRepository) {
        log.info("Successfully configured Notification Send Handler");
        return new NotifyClientsHandler(notificationRepository, messageRepository, receiverRepository, notificationSenderRepository, notificationSenderPort);
    }

}
