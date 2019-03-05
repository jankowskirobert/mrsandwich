package com.jvmless.mrsandwich.client.publication;

import com.jvmless.mrsandwich.location.Location;
import com.jvmless.mrsandwich.message.Message;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Publication {
    //db only, not for equal
    private PublicationId publicationId;
    private Message messageBody;
    private Location location;
    private LocalDate publicationDate;
    private PublicationStatus publicationStatus;

    public Publication(PublicationId publicationId, Message messageBody, Location location) {
        this.publicationId = publicationId;
        this.messageBody = messageBody;
        this.location = location;
        this.publicationDate = null;
        publicationStatus = PublicationStatus.UNSUBMITTED;
    }

    public void submitPublication() {
        this.publicationStatus = PublicationStatus.SUBMITTED;
        this.publicationDate = LocalDate.now();
    }
}
