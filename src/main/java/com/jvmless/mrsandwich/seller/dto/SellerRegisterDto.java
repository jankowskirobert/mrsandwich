package com.jvmless.mrsandwich.seller.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerRegisterDto {
    private String id ;
    private String firstName;
    private String lastName;
    private String city;
    private String postalCode;
    private String schedulerId;
    private List<String> locations;
}
