package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.*;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
