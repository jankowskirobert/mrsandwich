package com.jvmless.mrsandwich.seller;


import com.jvmless.mrsandwich.seller.api.CreateSeller;
import com.jvmless.mrsandwich.seller.dto.SellerDto;
import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import com.jvmless.mrsandwich.seller.dto.UpdateSellerPersonalDataDto;
import com.jvmless.mrsandwich.seller.exceptions.SellerNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SellerFacade {

    private final ModelMapper mapper = new ModelMapper();
    private SellerRepository sellerRepository;

    public void registerSeller(SellerRegisterDto dto) {
        Seller seller = sellerRepository.save(Seller.by(dto));
    }

    public void updateSellerPersonalData(UpdateSellerPersonalDataDto dto) {
        PersonalData personalData = PersonalData.of(dto);
        Optional<Seller> seller = sellerRepository.find(dto.getSellerId());
        seller.ifPresent(x -> x.updatePersonalData(personalData));
    }

    public List<SellerDto> getAvailableSellers() {
        return sellerRepository.findAllAvailableSellers().stream().map(x -> mapper.map(x, SellerDto.class)).collect(Collectors.toList());
    }

    public SellerDto getSeller(@NonNull String sellerId) {
        return mapper.map(
                sellerRepository.find(sellerId).orElseThrow(
                        () -> new SellerNotFoundException(String.format("Cannot find vendor with id: %s", sellerId))
                ), SellerDto.class);

    }

    public void createSeller(CreateSeller createSeller) {

    }
}
