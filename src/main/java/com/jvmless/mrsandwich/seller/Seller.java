package com.jvmless.mrsandwich.seller;

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

    public static Seller by(SellerRegisterRequestDto dto) {
        return null;
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalDataUpdateTime = LocalDateTime.now();
        this.personalData = personalData;
    }
}
