package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.api.MQSender;
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
    private MQSender mqSender;

    public static ClientFacade of(ClientRepository clientRepository, MQSender mqSender) {
        return new ClientFacade(clientRepository, mqSender);
    }

    public ClientFacade(ClientRepository clientRepository, MQSender mqSender) {
        this.clientRepository = clientRepository;
        this.mqSender = mqSender;
    }

    public void registerClient(@Valid @NonNull RegisterClientDto dto) {
        Client client = Client.by(dto);
        try {
            log.info("New Client: {}", dto.toString());
            Client c = clientRepository.save(client);
            mqSender.registerClientMessage(dto);
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
        });
    }

    public void addSellerToObserverList(@NonNull AddSellerDto dto) {
        ClientId id = new ClientId(dto.getClientId());
        Optional<Client> saved = clientRepository.findById(id);
        saved.ifPresent(x -> {
            if (x.isEnable()) {
                x.addSeller(dto.getSellerId());
            } else {
                throw new ClientDisabledException();
            }
        });
    }

    public void removeSellerFromObserverList(@NonNull RemoveSellerDto dto) {
        ClientId id = new ClientId(dto.getClientId());
        Optional<Client> saved = clientRepository.findById(id);
        saved.ifPresent(x -> {
            if (x.isEnable()) {
                x.removeSeller(dto.getSelledId());
            }
        });
    }

    public Set<ObservedSellerDto> getObservedSellers(@NonNull String clientId) {
        ClientId id = new ClientId(clientId);
        Optional<Client> saved = clientRepository.findById(id);
        return saved.map(x -> x.getSellers()).orElse(Collections.emptySet()).stream().map(y -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(y, ObservedSellerDto.class);
        }).collect(Collectors.toSet());
    }

}
