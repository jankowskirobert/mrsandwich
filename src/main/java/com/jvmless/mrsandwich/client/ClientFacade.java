package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.AddSellerDto;
import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.ClientDisabledException;
import com.jvmless.mrsandwich.client.exceptions.ClientRegisterException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
public class ClientFacade {

    private ClientRepository clientRepository;

    public static ClientFacade of(ClientRepository clientRepository) {
        return new ClientFacade(clientRepository);
    }

    public ClientFacade(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(@Valid @NonNull RegisterClientDto dto) {
        Client client = Client.by(dto);
        try {
            log.info("New Client: {}", dto.toString());
            Client c = clientRepository.save(client);
        } catch (Exception ex) {
            throw new ClientRegisterException(ex);
        }
    }

    public void disableClient(@NonNull DisableClientDto dto) {
        Optional<Client> saved = clientRepository.findById(dto.getClientId());
        saved.ifPresent(x -> {

            x.disable();
            clientRepository.update(x);

        });
    }

    public void addSellerToObserverList(@NonNull AddSellerDto dto) {
        Optional<Client> saved = clientRepository.findById(dto.getClientId());
        saved.ifPresent(x -> {
            if (x.isEnable()) {
                x.addSeller(dto.getSellerId());
            } else {
                throw new ClientDisabledException();
            }
        });
    }

    public void removeSellerFromObserverList(@NonNull RemoveSellerDto dto) {
        Optional<Client> saved = clientRepository.findById(dto.getClientId());
        saved.ifPresent(x -> {
            if (x.isEnable()) {
                x.removeSeller(dto.getSelledId());
            }
        });
    }
}
