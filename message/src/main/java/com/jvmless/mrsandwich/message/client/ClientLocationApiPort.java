package com.jvmless.mrsandwich.message.client;

import com.jvmless.mrsandwich.message.client.ClientDto;

public interface ClientLocationApiPort {
    ClientDto findByOrganization(String clientId);
}
