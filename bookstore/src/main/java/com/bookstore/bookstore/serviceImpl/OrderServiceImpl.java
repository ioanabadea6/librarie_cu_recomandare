package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.repo.OrderBookRepo;
import com.bookstore.bookstore.repo.OrderRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;
    private UserRepo userRepo;
    private OrderBookRepo orderBookRepo;

    /**
     * Constructs an {@code OrderServiceImpl} with the specified repositories.
     *
     * @param orderRepo The repository for {@code Order} entities.
     * @param userRepo The repository for {@code User} entities.
     * @param orderBookRepo The repository for {@code OrderBook} entities.
     */
    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo, OrderBookRepo orderBookRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.orderBookRepo = orderBookRepo;
    }

    /**
     * Inserts an order into the system.
     *
     * @param orderData The data of the order to be inserted.
     * @return The inserted order.
     */
    @Override
    public Order insertOrder(OrderData orderData) {
        Order order = new Order();
        order.setName(orderData.getName());
        order.setEmail(orderData.getEmail());
        order.setContactNumber(orderData.getContactNumber());
        order.setPaymentMethod(orderData.getPaymentMethod());
        order.setTotal(orderData.getTotal());
        order.setProductDetails(orderData.getProductDetails());
        order.setCreatedBy(orderData.getCreatedBy());
        order.setUser(userRepo.findUserById(orderData.getUserId()));
        //order.setOrderBooks(orderData.getBooksId(orderBookRepo.findByOrderId(orderData.get)));
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
        order.setProductDetails(orderData.getProductDetails());
        order.setCreatedBy(orderData.getCreatedBy());
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
        Order order = findOrder(orderData);
        order.setName(orderData.getName());
        order.setEmail(orderData.getEmail());
        order.setContactNumber(orderData.getContactNumber());
        order.setPaymentMethod(orderData.getPaymentMethod());
        order.setTotal(orderData.getTotal());
        order.setProductDetails(orderData.getProductDetails());
        order.setCreatedBy(orderData.getCreatedBy());
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
        return order;
    }
}
