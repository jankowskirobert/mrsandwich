package com.jvmless.mrsandwich.client;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
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
           if(x.isEnable()){
               x.disable();
               clientRepository.save(x);
           } else {
               throw new ClientAlreadyDisabled();
           }
       });
    }
    /*
    Add seller id to observer list,
     */
    public List<ClientSeller> addSeller(AddSellerDto dto){
        return new ArrayList<>();
    }

}
