package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.OrderBookData;
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

    @PostMapping("/insert")
    public OrderBookData insertOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.insertOrderBook(orderBookData);
        return orderBookData;
    }

    @GetMapping("/find")
    public OrderBookData findOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.findOrderBook(orderBookData);
        return orderBookData;
    }

    @DeleteMapping("/delete")
    public void deleteOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.deleteOrderBook(orderBookData);
    }

    @PutMapping("/update")
    public OrderBookData updateOrderBook(@RequestBody OrderBookData orderBookData){
        this.orderBookService.updateOrderBook(orderBookData);
        return orderBookData;
    }

    @GetMapping("/findAll")
    public List<OrderBook> findAll(){
        return this.orderBookService.findAll();
    }

}
