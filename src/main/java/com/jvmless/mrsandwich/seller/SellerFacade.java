package com.jvmless.mrsandwich.seller;


public class SellerFacade {

    private final SellerRepository sellerRepository;

    public SellerFacade(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerRegisterResponseDto registerSeller(SellerRegisterRequestDto dto){
        Seller seller = sellerRepository.save(Seller.by(dto));
        return null;
    }
}
