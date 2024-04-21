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

    /**
     * Constructs an {@code OrderBookServiceImpl} with the specified repositories.
     *
     * @param orderBookRepo The repository for {@code OrderBook} entities.
     * @param orderRepo The repository for {@code Order} entities.
     * @param bookRepo The repository for {@code Book} entities.
     */
    public OrderBookServiceImpl(OrderBookRepo orderBookRepo, OrderRepo orderRepo, BookRepo bookRepo) {
        this.orderBookRepo = orderBookRepo;
        this.orderRepo = orderRepo;
        this.bookRepo = bookRepo;
    }

    /**
     * Inserts an order book into the system.
     *
     * @param orderBookData The data of the order book to be inserted.
     * @return The inserted order book.
     */
    @Override
    public OrderBook insertOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(bookRepo.findBookById(orderBookData.getBook_id()));
        orderBook.setOrder(orderRepo.findById(orderBookData.getOrder_id()));
        orderBook.setQuantity(orderBookData.getQuantity());
        return orderBookRepo.save(orderBook);
    }

    /**
     * Deletes an order book from the system.
     *
     * @param orderBookData The data of the order book to be deleted.
     * @return The deleted order book.
     */
    @Override
    public OrderBook deleteOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = new OrderBook();
        orderBook = findOrderBook(orderBookData);
        orderBookRepo.delete(orderBook);
        return orderBook;
    }

    /**
     * Updates an existing order book in the system.
     *
     * @param orderBookData The new data for the order book.
     * @return The updated order book.
     */
    @Override
    public OrderBook updateOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = findOrderBook(orderBookData);
        orderBook.setBook(bookRepo.findBookById(orderBookData.getBook_id()));
        orderBook.setOrder(orderRepo.findById(orderBookData.getOrder_id()));
        orderBook.setQuantity(orderBookData.getQuantity());
        return orderBookRepo.save(orderBook);
    }

    /**
     * Finds an order book by its data.
     *
     * @param orderBookData The data of the order book to be found.
     * @return The found order book.
     */
    @Override
    public OrderBook findOrderBook(OrderBookData orderBookData) {
        OrderBook orderBook = new OrderBook();
        orderBook = orderBookRepo.findByOrderId(orderBookData.getOrder_id());
        return orderBook;
    }

    /**
     * Retrieves all order books from the system.
     *
     * @return A list of all order books.
     */
    @Override
    public List<OrderBook> findAll() {
        return orderBookRepo.findAll();
    }


}
