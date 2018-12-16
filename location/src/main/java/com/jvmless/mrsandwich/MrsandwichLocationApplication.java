package com.jvmless.mrsandwich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jvmless.mrsandwich.location", "com.jvmless.mrsandwich.location"})
public class MrsandwichLocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MrsandwichLocationApplication.class, args);
    }
}
