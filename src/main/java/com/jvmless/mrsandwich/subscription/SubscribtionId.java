package com.jvmless.mrsandwich.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SubscribtionId {
    private String id;
}
