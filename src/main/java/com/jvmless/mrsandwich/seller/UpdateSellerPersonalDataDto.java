package com.jvmless.mrsandwich.seller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class UpdateSellerPersonalDataDto {
    private String sellerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
}
