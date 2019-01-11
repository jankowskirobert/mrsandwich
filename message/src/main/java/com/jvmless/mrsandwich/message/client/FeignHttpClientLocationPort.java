package com.jvmless.mrsandwich.message.client;

import com.jvmless.mrsandwich.message.client.ClientDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "location")
public interface FeignHttpClientLocationPort {
    @GetMapping("/client/{clientId}")
    ClientDto findByOrganization(@PathVariable("clientId") String clientId);
}
