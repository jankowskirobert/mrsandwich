package com.jvmless.mrsandwich.receiver;

import com.jvmless.mrsandwich.message.TargetId;

import java.util.Optional;
import java.util.stream.Stream;

public interface ReceiverRepository {
    void save(Receiver receiver);
    Stream<Receiver> findAll();
    Optional<Receiver> find(ClientId id);

    Stream<Receiver> findByTargetArea(TargetId targetArea);
}
