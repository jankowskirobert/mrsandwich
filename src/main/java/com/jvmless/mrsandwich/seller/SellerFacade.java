package com.jvmless.mrsandwich.seller;


import java.util.Optional;

public class SellerFacade {

    private final SellerRepository sellerRepository;

    public SellerFacade(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void registerSeller(SellerRegisterRequestDto dto) {
        Seller seller = sellerRepository.save(Seller.by(dto));
    }

    public void updateSellerPersonalData(UpdateSellerPersonalDataDto dto) {
        PersonalData personalData = PersonalData.of(dto);
        Optional<Seller> seller = sellerRepository.find(dto.getSellerId());
        seller.ifPresent(x -> x.updatePersonalData(personalData));
    }
}
