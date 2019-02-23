package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Document(collection = "sellers")
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
        return new Seller(
                dto.getId(),
                PersonalData.of(dto.getFirstName(),
                        dto.getLastName(),
                        LocalDate.MIN),
                new Area(),
                Arrays.asList(new Location()),
                LocalDateTime.now()
        );
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalDataUpdateTime = LocalDateTime.now();
        this.personalData = personalData;
    }
}
