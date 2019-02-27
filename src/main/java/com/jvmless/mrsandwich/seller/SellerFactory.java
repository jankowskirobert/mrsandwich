package com.jvmless.mrsandwich.seller;

import com.jvmless.mrsandwich.location.Location;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SellerFactory {

    public static Seller createNeSeller(String sellerId, List<Location> locations) {
        return new Seller(new SellerId(sellerId), locations);
    }
    public static Seller createNeSeller(String sellerId, Location...locations) {
        return new Seller(new SellerId(sellerId), Arrays.asList(locations));
    }public static Seller createNeSeller(String sellerId) {
        return new Seller(new SellerId(sellerId), Collections.emptyList());
    }
}
