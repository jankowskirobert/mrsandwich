package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.NewClientLocation;

public class ReceiverFacade {

    private ReceiverRepository receiverRepository;
    private ClientLocationApiPort clientLocationApiPort;

    public ReceiverFacade(ReceiverRepository receiverRepository, ClientLocationApiPort clientLocationApiPort) {
        this.receiverRepository = receiverRepository;
        this.clientLocationApiPort = clientLocationApiPort;
    }

    public void registerNewClientWithLocation(NewClientLocation newClientLocation) {
        ReceiverDto receiverDto = clientLocationApiPort.findByOrganization(newClientLocation.getClientId());
        Receiver receiver = Receiver.map(receiverDto);
        receiverRepository.save(receiver);
    }
}
