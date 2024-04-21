package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.OrderBookData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderBookService {
    OrderBook insertOrderBook(OrderBookData orderBookData);
    void deleteOrderBook(OrderBookData orderBookData);
    OrderBook updateOrderBook(OrderBookData orderBookData);
    OrderBook findOrderBook(OrderBookData orderBookData);
    List<OrderBook> findAll();
    List<Book> findBooks(OrderBookData orderBookData);

}
