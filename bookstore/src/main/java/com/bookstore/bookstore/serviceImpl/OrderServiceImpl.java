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

    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo, OrderBookRepo orderBookRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.orderBookRepo = orderBookRepo;
    }


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

    @Override
    public void deleteOrder(OrderData orderData) {
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
    }

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

    @Override
    public Order findOrder(OrderData orderData) {
        Order order = new Order();
        order = orderRepo.findByName(orderData.getName());
        return order;
    }
}
