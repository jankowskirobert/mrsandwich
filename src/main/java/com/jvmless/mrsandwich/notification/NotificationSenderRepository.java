package com.jvmless.mrsandwich.notification;

public interface NotificationSenderRepository {
    Vendor save(Vendor vendor);
    Vendor findBy(VendorId vendorId);
}
