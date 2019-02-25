package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.seller.dto.SellerRegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Document(collection = "sellers")
class Seller {
    @Id
    private String id;
    private PersonalData personalData;
    private List<Location> handlingTargetLocations;
    private List<Subscriber> subscribers;
    private LocalDateTime personalDataUpdateTime;

    public String id() {
        return id;
    }

    public static Seller by(SellerRegisterDto dto) {
        return new Seller(
                dto.getId(),
                PersonalData.of(dto.getFirstName(),
                        dto.getLastName(),
                        LocalDate.MIN),
                Arrays.asList(new Location()),
                new ArrayList<>(),
                LocalDateTime.now()
        );
    }

    public void updatePersonalData(PersonalData personalData) {
        this.personalDataUpdateTime = LocalDateTime.now();
        this.personalData = personalData;
    }

    public void addSubscriber(Subscriber subscriber) {
        if(subscribers.contains(subscriber)) {
            Subscriber onList = subscribers.stream().filter(x -> x.equals(subscriber)).findFirst().get();
            if(onList.activated())
                throw new IllegalArgumentException("Cannot add subscriber, already on list");
            onList.activate();
        } else {
            subscribers.add(subscriber);
        }
    }

    public void deactivateSubscriber(Subscriber subscriber) {
        if(subscribers.contains(subscriber)) {
            Subscriber onList = subscribers.stream().filter(x -> x.equals(subscriber)).findFirst().get();
            if(onList.isRemoved())
                throw new IllegalArgumentException("Cannot deactivate subscriber, not on the list");
            onList.deactivate();
        } else {
            throw new IllegalArgumentException("Cannot deactivate subscriber, not on the list");
        }
    }
}
