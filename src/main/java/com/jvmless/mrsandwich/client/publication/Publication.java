package com.jvmless.mrsandwich.client.publication;

import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.message.Message;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Publication {
    private PublicationId publicationId;
    private Message messageBody;
    private Location location;
    private LocalDate publicationDate;

    public Publication(PublicationId publicationId, Message messageBody, Location location) {
        this.publicationId = publicationId;
        this.messageBody = messageBody;
        this.location = location;
        this.publicationDate = LocalDate.now();
    }
}
