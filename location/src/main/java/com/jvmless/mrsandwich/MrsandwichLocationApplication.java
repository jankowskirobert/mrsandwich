package com.jvmless.mrsandwich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.jvmless.mrsandwich.location"})
public class MrsandwichLocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MrsandwichLocationApplication.class, args);
    }
}
