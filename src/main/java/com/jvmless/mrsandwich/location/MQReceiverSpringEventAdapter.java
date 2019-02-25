package com.jvmless.mrsandwich.location;

import com.jvmless.mrsandwich.client.events.NewClientRegistered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@Slf4j
public class MQReceiverSpringEventAdapter implements MQReceiver {

    private final ClientLocationRepository clientLocationRepository;

    public MQReceiverSpringEventAdapter(ClientLocationRepository clientLocationRepository) {
        this.clientLocationRepository = clientLocationRepository;
    }

    @EventListener
    @Override
    public void newClientRegistered(NewClientRegistered incomingClient) {
        try {
            log.info("New client in location");
            Client client = Client.from(new IncomingClient(incomingClient.getId()));
            clientLocationRepository.save(client);
        } catch (Exception ex) {
            log.error("Cannot register new client in location");
        }
    }
}
