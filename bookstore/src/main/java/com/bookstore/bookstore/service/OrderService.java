package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.*;
import com.bookstore.bookstore.model.OrderData;

public interface OrderService {
    public Order insertOrder(OrderData orderData);
    public void deleteOrder(OrderData orderData);
    public Order updateOrder(OrderData orderData);

    public Order findOrder(OrderData orderData);

}
