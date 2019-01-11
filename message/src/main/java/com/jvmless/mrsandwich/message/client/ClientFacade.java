package com.jvmless.mrsandwich.message.client;

import com.jvmless.mrsandwich.message.NewClientLocation;

public class ClientFacade {

    private ClientRepository clientRepository;
    private ClientLocationApiPort clientLocationApiPort;

    public ClientFacade(ClientRepository clientRepository, ClientLocationApiPort clientLocationApiPort) {
        this.clientRepository = clientRepository;
        this.clientLocationApiPort = clientLocationApiPort;
    }

    public void registerNewClientWithLocation(NewClientLocation newClientLocation) {
        ClientDto clientDto = clientLocationApiPort.findByOrganization(newClientLocation.getClientId());
        Client client = Client.map(clientDto);
        clientRepository.save(client);
    }
}
