package com.bookstore.bookstore.entity.dao;

import com.bookstore.bookstore.entity.UserPayment;
import org.springframework.data.repository.CrudRepository;

public interface UserPaymentDAO  extends CrudRepository<UserPayment, Long> {
}
