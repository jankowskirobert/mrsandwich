package com.jvmless.mrsandwich.notification;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class VendorId {
    private String id;
}
