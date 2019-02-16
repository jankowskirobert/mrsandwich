package com.jvmless.mrsandwich.notification;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationSenderRepositoryInMemory implements NotificationSenderRepository {

    private Map<VendorId, Vendor> inMemoryRepository = new ConcurrentHashMap<>();

    @Override
    public Vendor save(Vendor vendor) {
        return inMemoryRepository.put(vendor.getVendorId(), vendor);
    }

    @Override
    public Vendor findBy(VendorId vendorId) {
        return inMemoryRepository.get(vendorId);
    }
}
