package com.jvmless.mrsandwich.message;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DeveloperMessageConfiguration {
}
