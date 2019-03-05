package com.jvmless.mrsandwich.client.publication;

import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.message.Message;
import com.jvmless.mrsandwich.seller.Seller;

import java.time.LocalDate;
import java.util.List;

public class Publisher {
    private PublisherId publisherId;
    private List<Publication> publications;
    private Seller seller;

    public void publish(Message message, Location location) {
        LocalDate localDate = LocalDate.now();
        long currentPublicationsInLocation = publications
                .stream()
                .filter(x -> x.getLocation().equals(location) && x.getPublicationDate().equals(localDate))
                .count();
        if(currentPublicationsInLocation > 3) {
            throw new IllegalStateException("Cannot publish more then 3 messages for this location today");
        } else {
            publications.add(new Publication(new PublicationId(), message, location));
        }
    }
}
