package com.jvmless.mrsandwich.message.client;

class ClientLocationHttpAdapter implements ClientLocationApiPort {

    private FeignHttpClientLocationPort feignHttpClientLocationPort;

    @Override
    public ClientDto findByOrganization(String clientId) {
        return feignHttpClientLocationPort.findByOrganization(clientId);
    }
}
