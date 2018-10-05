package com.jvmless.mrsandwich.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveSellerDto {
    private String clientId;
    private String selledId;
}
