package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.SellerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "register-notificationSender")
interface SellerHttpApi {

    @GetMapping("/seller/{sellerId}")
    SellerDto getSellerDetails(@PathVariable("sellerId") Long sellerId);

}