package com.jvmless.mrsandwich.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
@AllArgsConstructor
@Data
public class RegisterClientDto {
    @NotNull
    private String clientId;
}
