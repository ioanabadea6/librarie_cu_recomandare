package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing order-related operations.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    /**
     * Constructor for OrderController.
     *
     * @param orderService The OrderService instance to be used for order operations.
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Endpoint for inserting a new order.
     *
     * @param orderData The OrderData object representing the order to be inserted.
     * @return The inserted OrderData object.
     */
    @PostMapping("/insert")
    public OrderData registerOrder(@RequestBody OrderData orderData) {
        this.orderService.insertOrder(orderData);
        return orderData;
    }

    /**
     * Endpoint for finding an order.
     *
     * @param orderData The OrderData object representing the order to be found.
     * @return The found OrderData object.
     */
    @PostMapping("/find")
    public OrderData findOrder(@RequestBody OrderData orderData) {
        this.orderService.findOrder(orderData);
        return orderData;
    }

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    /**
     * Endpoint for deleting an order.
     *
     * @param orderData The OrderData object representing the order to be deleted.
     */
    @DeleteMapping("/delete")
    public void deleteOrder(@RequestBody OrderData orderData) {
        this.orderService.deleteOrder(orderData);
    }

    /**
     * Endpoint for updating an order.
     *
     * @param orderData The OrderData object representing the order to be updated.
     * @return The updated OrderData object.
     */
    @PutMapping("/update")
    public OrderData updateOrder(@RequestBody OrderData orderData) {
        this.orderService.updateOrder(orderData);
        return orderData;
    }

    @PostMapping("/findByUsername")
    public List<Order> findByUsername(@RequestBody UsernameData usernameData) {
        return orderService.findByUsername(usernameData);
    }
}
