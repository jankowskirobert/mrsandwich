package com.jvmless.mrsandwich.seller;


import com.jvmless.mrsandwich.seller.dto.SellerDto;
import com.jvmless.mrsandwich.seller.dto.SellerRegisterRequestDto;
import com.jvmless.mrsandwich.seller.dto.UpdateSellerPersonalDataDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SellerFacade {
    private final ModelMapper mapper = new ModelMapper();
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
        return sellerRepository.findAllAvailableSellers().stream().map(x -> mapper.map(x, SellerDto.class)).collect(Collectors.toList());
    }
}
