package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    Order findByUuid(String uuid);
    Order findByName(String name);
}
