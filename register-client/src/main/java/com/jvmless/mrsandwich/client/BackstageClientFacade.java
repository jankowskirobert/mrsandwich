package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.BackstageClientStatsDto;
import com.jvmless.mrsandwich.client.dto.ClientDetailsDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BackstageClientFacade {

    private ClientRepository clientRepository;

    public BackstageClientFacade(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public BackstageClientStatsDto stats() {
        return BackstageClientStatsDto.from(clientRepository.fullStats());
    }

    public List<ClientDetailsDto> all() {
        return null;
    }
}
