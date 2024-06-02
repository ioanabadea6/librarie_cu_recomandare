package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.model.OrderBookData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderBookService {
    /**
     * Inserts an order book into the system.
     *
     * @param orderBookData The data of the order book to be inserted.
     * @return The inserted order book.
     */
    OrderBook insertOrderBook(OrderBookData orderBookData);
    /**
     * Deletes an order book from the system.
     *
//     * @param orderBookData The data of the order book to be deleted.
     * @return The deleted order book.
     */
    public void deleteByBookId(Integer bookId);
    /**
     * Updates an existing order book in the system.
     *
     * @param orderBookData The new data for the order book.
     * @return The updated order book.
     */
    OrderBook updateOrderBook(OrderBookData orderBookData);
    /**
     * Finds an order book by its data.
     *
     * @param orderBookData The data of the order book to be found.
     * @return The found order book.
     */
    OrderBook findOrderBook(OrderBookData orderBookData);
    /**
     * Retrieves all order books from the system.
     *
     * @return A list of all order books.
     */
    List<OrderBook> findAll();


    void deleteAll();

}
