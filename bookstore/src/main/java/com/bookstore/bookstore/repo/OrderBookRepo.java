package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderBookRepo extends JpaRepository<OrderBook,Integer> {
    /**
     * Finds an order book by its order ID.
     *
//     * @param order_id The ID of the order.
     * @return The found order book.
     */
//  OrderBook findByOrderBookId(Integer order_id);

//    @Query("SELECT ob FROM OrderBook ob WHERE ob.order.id = :orderId")
//    List<OrderBook> findByOrderId(Integer orderId);


    OrderBook findByBook(Book book);

}
