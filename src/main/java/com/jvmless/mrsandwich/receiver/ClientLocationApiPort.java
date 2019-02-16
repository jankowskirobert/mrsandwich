package com.jvmless.mrsandwich.receiver;

public interface ClientLocationApiPort {
    ReceiverDto findByOrganization(String clientId);
}
