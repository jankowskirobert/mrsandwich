package com.jvmless.mrsandwich.seller.api;

import com.jvmless.mrsandwich.seller.dto.SellerDto;
import com.jvmless.mrsandwich.seller.SellerFacade;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
Controller for mobile devices and other apis
 */
@RestController()
@RequestMapping("/seller")
class SellerHttpApi {

    private final SellerFacade sellerFacade;

    public SellerHttpApi(SellerFacade sellerFacade) {
        this.sellerFacade = sellerFacade;
    }

    @RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.GET)
    public SellerDto getSeller(@PathVariable(name = "id", required = true) String sellerId) {
        return sellerFacade.getSeller(sellerId);
    }

    @RequestMapping(path = "", produces = "application/json", method = RequestMethod.GET)
    public List<SellerDto> getAvailableSellers() {
        return sellerFacade.getAvailableSellers();
    }
}
