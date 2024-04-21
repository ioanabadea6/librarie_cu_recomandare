package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderBookRepo extends JpaRepository<OrderBook,Integer> {
    OrderBook findByOrderId(Integer order_id);

}
