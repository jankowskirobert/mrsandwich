package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Document(collection = "sellers")
@Getter
public class Seller {
    @Id
    private SellerId id;
    private PersonalData personalData;
    private List<Location> handlingTargetLocations;
    private LocalDateTime personalDataUpdateTime;


    public static Seller by(SellerRegisterDto dto) {
        return null
                ;
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalDataUpdateTime = LocalDateTime.now();
        this.personalData = personalData;
    }

    public boolean isHandlingLocation(Location location) {
        return handlingTargetLocations.contains(location);
    }

}
