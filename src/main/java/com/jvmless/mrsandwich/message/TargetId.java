package com.jvmless.mrsandwich.message;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
@Getter
public class TargetId {
    private String id;
}
