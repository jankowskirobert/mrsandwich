package com.jvmless.mrsandwich.message;

public class ClientFacade {

    private ClientRepository clientRepository;
    private ClientLocationPort clientLocationPort;

    public ClientFacade(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerNewClientWithLocation(NewClientLocation newClientLocation) {
        ClientDto clientDto = clientLocationPort.findByOrganization(newClientLocation.getClientId());
        Client client = Client.map(clientDto);
        clientRepository.save(client);
    }
}
