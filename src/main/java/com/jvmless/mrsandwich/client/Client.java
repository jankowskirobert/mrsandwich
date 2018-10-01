package com.jvmless.mrsandwich.client;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
/*
    add mapping to another model that contains mongodb annotations
 */
@Document(collection = "client")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Client {
    private String clientId;
    private ClientStatus status;
    private LocalDateTime terminated;
    private LocalDateTime created;

    public String id() {
        return clientId;
    }

    public static Client by(@NonNull RegisterClientDto dto) {
        return new Client(dto.getClientId(), ClientStatus.ENABLE, null, LocalDateTime.now());
    }

    public boolean isEnable() {
        if(status.equals(ClientStatus.ENABLE))
            return true;
        return false;
    }

    public void disable() {
        this.status = ClientStatus.DISABLE;
        terminated = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
