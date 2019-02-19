package com.jvmless.mrsandwich.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@Data
@EqualsAndHashCode
public class MessageId {
    private String id;
}
