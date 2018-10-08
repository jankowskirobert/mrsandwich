package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.UpdateSellerPersonalDataDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonalData {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;

    public static PersonalData of(UpdateSellerPersonalDataDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, PersonalData.class);
    }
}
