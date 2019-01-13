package com.jvmless.mrsandwich.client;

public interface ClientLocationApiPort {
    ClientDto findByOrganization(String clientId);
}
