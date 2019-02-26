package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.dto.RegisterClientDto;
import com.jvmless.mrsandwich.client.exceptions.ClientAlreadyDisabledException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Document(collection = "client")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Client {
    @Id
    private ClientId clientId;
    private ClientStatus status;
    private LocalDateTime terminated;
    private LocalDateTime created;

    public String id() {
        return clientId.id();
    }

    public static Client by(@NonNull RegisterClientDto dto) {
        return null;
    }

    public boolean isEnable() {
        if (status.equals(ClientStatus.ENABLE))
            return true;
        return false;
    }

    public void disable() {
        if (this.status.equals(ClientStatus.DISABLE))
            throw new ClientAlreadyDisabledException();
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
