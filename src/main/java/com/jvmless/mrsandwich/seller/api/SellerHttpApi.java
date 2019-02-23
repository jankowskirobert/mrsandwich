package com.jvmless.mrsandwich.seller.api;

import com.jvmless.mrsandwich.seller.SellerId;
import com.jvmless.mrsandwich.seller.dto.SellerDto;
import com.jvmless.mrsandwich.seller.SellerFacade;
import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public SellerId createSeller(@RequestBody SellerRegisterDto createSeller) {
        sellerFacade.registerSeller(createSeller);
        return new SellerId(createSeller.getId());
    }


}
