package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.AddSellerDto;
import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.ClientDisabledException;
import com.jvmless.mrsandwich.client.exceptions.ClientRegisterException;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@AllArgsConstructor(staticName = "of")
public class ClientFacade {

    private ClientRepository clientRepository;

    public void registerClient(@NonNull RegisterClientDto dto) {
        Client client = Client.by(dto);
        try {
            Client c = clientRepository.save(client);
        } catch (Exception ex) {
            throw new ClientRegisterException();
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
            if(x.isEnable()){
                x.observerSeller(Correlation.of(dto.getSellerId()));
            } else {
                throw new ClientDisabledException();
            }
        });
    }

    public void removeSellerFromObserverList(@NonNull RemoveSellerDto dto) {
        Optional<Client> saved = clientRepository.findById(dto.getClientId());
        saved.ifPresent(x -> {
            if(x.isEnable()){
                x.stopObservingSeller(dto.getSelledId());
            }
        });
    }
}
