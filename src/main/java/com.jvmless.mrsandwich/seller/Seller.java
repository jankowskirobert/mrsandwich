package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

class Seller {
    @Id
    private String id;
    private PersonalData personalData;
    private Area area;
    private List<Location> locations;
    private LocalDateTime personalDataUpdateTime;

    public String id() {
        return id;
    }

    public static Seller by(SellerRegisterDto dto) {
        return null;
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalDataUpdateTime = LocalDateTime.now();
        this.personalData = personalData;
    }
}
