package com.jvmless.mrsandwich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
Location is updated rarely to set job place, so methods in this service will be not invoked often.
Mostly messages sending will be used.
 */
@EnableDiscoveryClient
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.jvmless.mrsandwich.location"})
public class ClientLocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientLocationApplication.class, args);
    }
}
