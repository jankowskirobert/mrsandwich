package com.jvmless.mrsandwich.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveSellerDto {
    private String clientId;
    private String selledId;
}
