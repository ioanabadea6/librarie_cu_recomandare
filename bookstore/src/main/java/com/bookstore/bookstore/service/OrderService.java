package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.*;

public interface OrderService {
    Order createOrder(ShoppingCart shoppingCart,
                      ShippingAddress shippingAddress,
                      BillingAddress billingAddress,
                      Payment payment,
                      String shippingMehod,
                      User user);

    Order findOne(Long id);
}
