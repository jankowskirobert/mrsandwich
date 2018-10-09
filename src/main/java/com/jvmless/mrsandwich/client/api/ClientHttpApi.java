package com.jvmless.mrsandwich.client.api;


import com.jvmless.mrsandwich.client.ClientFacade;
import com.jvmless.mrsandwich.client.dto.ClientObservedSellersDto;
import com.jvmless.mrsandwich.client.dto.DisableClientDto;
import com.jvmless.mrsandwich.client.dto.ObservedSellerDto;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.seller.SellerFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController()
@RequestMapping("/client")
@Slf4j
class ClientHttpApi {

    private final ClientFacade clientFacade;
    private final SellerFacade sellerFacade;

    @Autowired
    public ClientHttpApi(ClientFacade clientFacade, SellerFacade sellerFacade) {
        this.clientFacade = clientFacade;
        this.sellerFacade = sellerFacade;
    }

    @RequestMapping(path = "/register", consumes = "application/json", method = RequestMethod.POST)
    public void registerClient(@RequestBody RegisterClientDto dto) {
        clientFacade.registerClient(dto);
    }


    @RequestMapping(path = "/disable", consumes = "application/json", method = RequestMethod.POST)
    public void disableClient(@RequestBody DisableClientDto dto) {
        clientFacade.disableClient(dto);
    }


    @RequestMapping(path = "/observe", consumes = "application/json", method = RequestMethod.POST)
    public void observerSeller(@RequestBody DisableClientDto dto) {
        clientFacade.disableClient(dto);
    }

    @RequestMapping(path = "/observe", consumes = "application/json", method = RequestMethod.DELETE)
    public void stopWatchingSeller(@RequestBody DisableClientDto dto) {
        clientFacade.disableClient(dto);
    }

    @RequestMapping(path = "/observed", produces = "application/json", method = RequestMethod.GET)
    public List<ObservedSellerDto> listOfWatchedSellers(@RequestParam String clientId) {
        return new ArrayList<>(clientFacade.getObservedSellers(clientId));
    }
}
