package com.jvmless.mrsandwich.client.api.http;

import com.jvmless.mrsandwich.client.BackstageClientFacade;
import com.jvmless.mrsandwich.client.dto.BackstageClientStatsDto;
import com.jvmless.mrsandwich.client.dto.ClientDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/backstage")
class BackstageClientHttpApi {

    @Autowired
    private BackstageClientFacade backstageClientFacade;

    @RequestMapping(path = "/stats", consumes = "application/json", method = RequestMethod.GET)
    public BackstageClientStatsDto getStats() {
        return backstageClientFacade.stats();
    }

    @RequestMapping(path = "/all", consumes = "application/json", method = RequestMethod.GET)
    public List<ClientDetailsDto> getAllRegistredClients() {
        return backstageClientFacade.all();
    }


}
