package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderBookRepo extends JpaRepository<OrderBook,Integer> {
    /**
     * Finds an order book by its order ID.
     *
     * @param order_id The ID of the order.
     * @return The found order book.
     */
    OrderBook findByOrderId(Integer order_id);

}
