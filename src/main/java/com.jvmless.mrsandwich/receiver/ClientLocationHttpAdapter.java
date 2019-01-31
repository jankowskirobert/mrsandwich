package com.jvmless.mrsandwich.receiver;

class ClientLocationHttpAdapter implements ClientLocationApiPort {

    private FeignHttpClientLocationPort feignHttpClientLocationPort;

    @Override
    public ReceiverDto findByOrganization(String clientId) {
        return feignHttpClientLocationPort.findByOrganization(clientId);
    }
}
