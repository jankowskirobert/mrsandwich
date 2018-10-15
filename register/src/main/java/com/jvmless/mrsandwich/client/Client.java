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
import java.util.Objects;
import java.util.Set;

@Document(collection = "client")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Client {
    @Id
    private ClientId clientId;
    private ClientStatus status;
    private LocalDateTime terminated;
    private LocalDateTime created;
    private Set<Seller> sellers;

    public String id() {
        return clientId.id();
    }

    public static Client by(@NonNull RegisterClientDto dto) {
        return new Client(new ClientId(dto.getClientId()), ClientStatus.ENABLE, null, LocalDateTime.now(), new HashSet<>());
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

    public void addSeller(String sellerId) {
        Seller seller = Seller.of(sellerId);
        if (!sellers.contains(seller)) {
            sellers.add(seller);
        }
    }

    public void removeSeller(String sellerId) {
        Seller seller = Seller.of(sellerId);
        sellers.stream().filter(x -> x.equals(seller)).forEach(x -> x.deactivate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId);
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
