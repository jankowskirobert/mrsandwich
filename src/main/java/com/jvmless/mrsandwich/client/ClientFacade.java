package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.*;
import com.jvmless.mrsandwich.client.exceptions.ClientDisabledException;
import com.jvmless.mrsandwich.client.exceptions.ClientRegisterException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ClientFacade {

    private ClientRepository clientRepository;
    private MQSenderPort mqSenderPort;

    public static ClientFacade of(ClientRepository clientRepository, MQSenderPort mqSenderPort) {
        return new ClientFacade(clientRepository, mqSenderPort);
    }

    public ClientFacade(ClientRepository clientRepository, MQSenderPort mqSenderPort) {
        this.clientRepository = clientRepository;
        this.mqSenderPort = mqSenderPort;
    }

    public void registerClient(@Valid @NonNull RegisterClientDto dto) {
        Client client = ClientFactory.createNewClient(dto.getClientId());
        try {
            log.info("New Client: {}", dto.toString());
            Client c = clientRepository.save(client);
            mqSenderPort.registerClientMessage(dto);
        } catch (Exception ex) {
            throw new ClientRegisterException(ex);
        }
    }

    public void disableClient(@NonNull DisableClientDto dto) {
        ClientId id = new ClientId(dto.getClientId());
        Optional<Client> saved = clientRepository.findById(id);
        saved.ifPresent(x -> {
            x.disable();
            clientRepository.update(x);
            mqSenderPort.disableClientMessage(dto);
        });
    }



    public void newSellerRegister(NewSeller newSeller) {
        log.info("NEW SELLER");
    }


    public void sellerDisables(SellerDisabled newSeller) {
        log.info("Seller with id: "+newSeller.getSellerId()+" disabled");

    }

}
