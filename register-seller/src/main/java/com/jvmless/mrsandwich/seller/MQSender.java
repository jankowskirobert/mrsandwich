package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;

public interface MQSender {

    void newSellerregistrationMessage(SellerRegisterDto sellerDto);
}
