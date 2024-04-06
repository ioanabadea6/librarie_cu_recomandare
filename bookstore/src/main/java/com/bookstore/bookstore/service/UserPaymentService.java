package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
