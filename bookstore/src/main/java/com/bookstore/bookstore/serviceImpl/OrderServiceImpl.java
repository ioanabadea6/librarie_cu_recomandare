package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.repo.OrderRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo reposityOrder;

    public OrderServiceImpl(OrderRepo reposityOrder) {
        this.reposityOrder = reposityOrder;
    }

    @Override
    public Order insertOrder(OrderData orderData) {
        Order order = new Order();
        order.setUuid(orderData.getUuid());
        order.setName(orderData.getName());
        order.setEmail(orderData.getEmail());
        order.setContactNumber(orderData.getContactNumber());
        order.setPaymentMethod(orderData.getPaymentMethod());
        order.setTotal(orderData.getTotal());
        order.setProductDetails(orderData.getProductDetails());
        order.setCreatedBy(orderData.getCreatedBy());
        return reposityOrder.save(order);
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
        reposityOrder.delete(order);
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
        return reposityOrder.save(order);
    }

    @Override
    public Order findOrder(OrderData orderData) {
        Order order = new Order();
        order = reposityOrder.findByUuid(orderData.getUuid());
        return order;
    }
}
