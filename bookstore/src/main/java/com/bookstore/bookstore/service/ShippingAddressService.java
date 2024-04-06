package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.*;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
