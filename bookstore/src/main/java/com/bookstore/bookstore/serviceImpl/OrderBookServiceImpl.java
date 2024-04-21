package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.OrderBookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.OrderBookRepo;
import com.bookstore.bookstore.repo.OrderRepo;
import com.bookstore.bookstore.service.OrderBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderBookServiceImpl implements OrderBookService {
    private OrderBookRepo orderBookRepo;
    private OrderRepo orderRepo;
    private BookRepo bookRepo;

    public OrderBookServiceImpl(OrderBookRepo orderBookRepo, OrderRepo orderRepo, BookRepo bookRepo) {
        this.orderBookRepo = orderBookRepo;
        this.orderRepo = orderRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public OrderBook insertOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(bookRepo.findBookById(orderBookData.getBook_id()));
        orderBook.setOrder(orderRepo.findById(orderBookData.getOrder_id()));
        orderBook.setQuantity(orderBookData.getQuantity());
        return orderBookRepo.save(orderBook);
    }

    @Override
    public void deleteOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = new OrderBook();
        orderBook = findOrderBook(orderBookData);
        orderBookRepo.delete(orderBook);
    }

    @Override
    public OrderBook updateOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = findOrderBook(orderBookData);
        orderBook.setBook(bookRepo.findBookById(orderBookData.getBook_id()));
        orderBook.setOrder(orderRepo.findById(orderBookData.getOrder_id()));
        orderBook.setQuantity(orderBookData.getQuantity());
        return orderBookRepo.save(orderBook);
    }

    @Override
    public OrderBook findOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = new OrderBook();
        orderBook = orderBookRepo.findByOrderId(orderBookData.getOrder_id());
        return orderBook;
    }

    @Override
    public List<OrderBook> findAll() {
        return orderBookRepo.findAll();
    }

    @Override
    public List<Book> findBooks(OrderBookData orderBookData) {
        List<Book> books = new ArrayList<>();
        OrderBook orderBook = findOrderBook(orderBookData);
        books.add(orderBook.getBook());
        return books;
    }
}
