package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderBookRepo extends JpaRepository<OrderBook,Integer> {
    /**
     * Find an orderBook by book
     * @param book
     * @return
     */
    OrderBook findByBook(Book book);

}
