package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.model.OrderBookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.OrderBookRepo;
import com.bookstore.bookstore.repo.OrderRepo;
import com.bookstore.bookstore.repo.UserRepo;
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
        Book book = bookRepo.findById(orderBookData.getBook_id()).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getStock() < orderBookData.getQuantity()) {
            throw new RuntimeException("Not enough stock for book: " + book.getTitle());
        }

        // Reduce the stock
        book.setStock(book.getStock() - orderBookData.getQuantity());
        bookRepo.save(book);

        OrderBook orderBook = new OrderBook();
        orderBook.setBook(book);
        orderBook.setQuantity(orderBookData.getQuantity());
        return orderBookRepo.save(orderBook);
    }

    /**
     * Deletes an order book from the system.
     *
//     * @param orderBookData The data of the order book to be deleted.
     * @return The deleted order book.
     */
    @Override
    public void deleteByBookId(Integer bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        OrderBook orderBook = orderBookRepo.findByBook(book);

        orderBookRepo.delete(orderBook);
    }

    /**
     * Updates an existing order book in the system.
     *
     * @param orderBookData The new data for the order book.
     * @return The updated order book.
     */
    @Override
    public OrderBook updateOrderBook(OrderBookData orderBookData) {
        Book book = bookRepo.findById(orderBookData.getBook_id()).orElseThrow(() -> new RuntimeException("Book not found"));
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(book);
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
        Book book = bookRepo.findById(orderBookData.getBook_id()).orElseThrow(() -> new RuntimeException("Book not found"));
        OrderBook orderBook = orderBookRepo.findByBook(book);
        orderBookRepo.delete(orderBook);
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

//    @Override
//    public List<OrderBook> findByOrderId(Integer orderId) {
//        return orderBookRepo.findByOrderId(orderId);
//    }

    @Override
    public void deleteAll() {
        orderBookRepo.deleteAll();
    }



}
