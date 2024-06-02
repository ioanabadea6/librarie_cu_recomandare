package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.entity.Wishlist;
import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.repo.OrderBookRepo;
import com.bookstore.bookstore.repo.OrderRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;
    private UserRepo userRepo;

    /**
     * Constructs an {@code OrderServiceImpl} with the specified repositories.
     *
     * @param orderRepo The repository for {@code Order} entities.
     * @param userRepo The repository for {@code User} entities.
//     * @param orderBookRepo The repository for {@code OrderBook} entities.
     */
    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    /**
     * Inserts an order into the system.
     *
     * @param orderData The data of the order to be inserted.
     * @return The inserted order.
     */
    @Override
    public Order insertOrder(OrderData orderData) {
        User user = userRepo.findUserByEmail(orderData.getEmail());
        Order order = findOrder(orderData);
        if(order != null){
            order.setName(orderData.getName());
            order.setEmail(orderData.getEmail());
            order.setContactNumber(orderData.getContactNumber());
            order.setPaymentMethod(orderData.getPaymentMethod());
            order.setTotal(orderData.getTotal());
            order.setAddress(orderData.getAddress());
            order.setUser(user);
        }
        return orderRepo.save(order);
    }

    /**
     * Deletes an order from the system.
     *
     * @param orderData The data of the order to be deleted.
     * @return The deleted order.
     */
    @Override
    public Order deleteOrder(OrderData orderData) {
        Order order = new Order();
        order = findOrder(orderData);
        order.setName(orderData.getName());
        order.setEmail(orderData.getEmail());
        order.setContactNumber(orderData.getContactNumber());
        order.setPaymentMethod(orderData.getPaymentMethod());
        order.setTotal(orderData.getTotal());
        orderRepo.delete(order);
        return order;
    }

    /**
     * Updates an existing order in the system.
     *
     * @param orderData The new data for the order.
     * @return The updated order.
     */
    @Override
    public Order updateOrder(OrderData orderData) {
        User user = userRepo.findUserById(orderData.getUserId());
        Order order = findOrder(orderData);
        if(order != null){
            order.setName(orderData.getName());
            order.setEmail(orderData.getEmail());
            order.setContactNumber(orderData.getContactNumber());
            order.setPaymentMethod(orderData.getPaymentMethod());
            order.setTotal(orderData.getTotal());
            order.setAddress(orderData.getAddress());
            order.setUser(user);
        }
        return orderRepo.save(order);
    }

    /**
     * Finds an order by its data.
     *
     * @param orderData The data of the order to be found.
     * @return The found order.
     */
    @Override
    public Order findOrder(OrderData orderData) {
        Order order = new Order();
        order = orderRepo.findByName(orderData.getName());
        if(order != null){
            return order;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> findByUsername(UsernameData usernameData) {
        User user = userRepo.findByUsername(usernameData.getUsername());
        List<Order> orders = orderRepo.findByUser(user);
        if (orders.isEmpty()) {
            throw new RuntimeException("No orders found for user");
        }
        return orders;
    }
}
