package com.jvmless.mrsandwich.seller.api;

import com.jvmless.mrsandwich.seller.dto.SellerDto;
import com.jvmless.mrsandwich.seller.SellerFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/seller")
public class SellerHttpApi {

    private final SellerFacade sellerFacade;

    public SellerHttpApi(SellerFacade sellerFacade) {
        this.sellerFacade = sellerFacade;
    }

    @RequestMapping(path = "", produces = "application/json", method = RequestMethod.GET)
    public List<SellerDto> getAvailableSellers() {
        return sellerFacade.getAvailableSellers();
    }
}
