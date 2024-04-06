package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.*;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
