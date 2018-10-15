package com.jvmless.mrsandwich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jvmless.mrsandwich.client","com.jvmless.mrsandwich.seller"})
public class MrsandwichApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrsandwichApplication.class, args);
	}
}