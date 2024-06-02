package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.model.OrderBookData;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.OrderBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderBook")
public class OrderBookController {
    private OrderBookService orderBookService;

    public OrderBookController(OrderBookService orderBookService) {
        this.orderBookService = orderBookService;
    }

    /**
     * Inserts an order book into the system.
     *
//     * @param orderBookData The data of the order book to be inserted.
     * @return The inserted order book data.
     */
    @PostMapping("/insert")
    public OrderBookData insertOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.insertOrderBook(orderBookData);
        return orderBookData;
    }

    /**
     * Finds an order book in the system.
     *
     * @param orderBookData The data of the order book to find.
     * @return The found order book data.
     */
    @PostMapping("/find")
    public OrderBookData findOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.findOrderBook(orderBookData);
        return orderBookData;
    }

    /**
     * Deletes an order book from the system.
     *
//     * @param orderBookData The data of the order book to be deleted.
     */
    @DeleteMapping("/deleteByBookId/{bookId}")
    public void deleteByBookId(@PathVariable Integer bookId) {
        orderBookService.deleteByBookId(bookId);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        this. orderBookService.deleteAll();
    }

    /**
     * Updates an order book in the system.
     *
     * @param orderBookData The data of the order book to be updated.
     * @return The updated order book data.
     */
    @PutMapping("/update")
    public OrderBookData updateOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.updateOrderBook(orderBookData);
        return orderBookData;
    }

    /**
     * Retrieves all order books from the system.
     *
     * @return A list of all order books.
     */
    @GetMapping("/findAll")
    public List<OrderBook> findAll(){
        return this.orderBookService.findAll();
    }

//    @GetMapping("/findByOrderId/{orderId}")
//    public List<OrderBook> findByOrderId(@PathVariable Integer orderId) {
//        return orderBookService.findByOrderId(orderId);
//    }
}
