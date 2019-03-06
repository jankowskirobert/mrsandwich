package com.jvmless.mrsandwich.client.publication;

public interface PublisherRepository {
    Publisher find(PublisherId publisherId);

    void save(Publisher publisher);
}
