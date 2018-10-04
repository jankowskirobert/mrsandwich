package com.jvmless.mrsandwich.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class AddSellerDto {
    private String clientId;
    private String sellerId;
}
