package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/insert")
    public OrderData registerOrder(@RequestBody OrderData orderData) {
        this.orderService.insertOrder(orderData);
        return orderData;
    }


    @GetMapping("/find")
    public OrderData findOrder(@RequestBody OrderData orderData){
        this.orderService.findOrder(orderData);
        return orderData;
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestBody OrderData orderData){
        this.orderService.deleteOrder(orderData);
    }

    @PutMapping("/update")
    public OrderData updateOrder(@RequestBody OrderData orderData) {
        this.orderService.updateOrder(orderData);
        return orderData;
    }
}
