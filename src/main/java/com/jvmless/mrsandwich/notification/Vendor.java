package com.jvmless.mrsandwich.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "vendors")
public class Vendor {
    @Id
    private VendorId vendorId;
}
