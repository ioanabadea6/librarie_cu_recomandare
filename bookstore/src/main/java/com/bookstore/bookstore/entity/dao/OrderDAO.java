package com.bookstore.bookstore.entity.dao;

import com.bookstore.bookstore.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Long> {
}
