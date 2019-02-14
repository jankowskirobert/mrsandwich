package com.jvmless.mrsandwich.notification;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
@Getter
public class VendorId {
    private String id;
}
