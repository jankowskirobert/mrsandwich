package com.jvmless.mrsandwich.seller;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SellerFacade {

    private SellerRepository sellerRepository;

    protected void registerSeller(SellerRegisterRequestDto dto) {
        Seller seller = sellerRepository.save(Seller.by(dto));
    }

    protected void updateSellerPersonalData(UpdateSellerPersonalDataDto dto) {
        PersonalData personalData = PersonalData.of(dto);
        Optional<Seller> seller = sellerRepository.find(dto.getSellerId());
        seller.ifPresent(x -> x.updatePersonalData(personalData));
    }

    public List<SellerDto> getAvailableSellers() {
        return sellerRepository.findAllAvailableSellers().stream().map(x -> SellerDto.from(x)).collect(Collectors.toList());
    }
}
