package com.jvmless.mrsandwich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.jvmless.mrsandwich.client", "com.jvmless.mrsandwich.seller"})
public class RegisterApp {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApp.class, args);
	}
}
