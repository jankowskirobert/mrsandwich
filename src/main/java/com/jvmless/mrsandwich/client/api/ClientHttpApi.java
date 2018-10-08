package com.jvmless.mrsandwich.client.api;


import com.jvmless.mrsandwich.client.ClientFacade;
import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.seller.SellerFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
