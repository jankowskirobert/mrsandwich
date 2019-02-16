package com.jvmless.mrsandwich.client.dto;

import com.jvmless.mrsandwich.client.ClientStats;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class BackstageClientStatsDto {
    int totalClientCount;
    int totalUniqueSellersAttachedToAllClients;
    int totalEnabledClients;
    public static BackstageClientStatsDto from(ClientStats fullStats) {
        return new BackstageClientStatsDto();
    }
}
