package com.jvmless.mrsandwich.message;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "targets")
public class TargetArea {
    @Id
    private TargetId targetId;
}
