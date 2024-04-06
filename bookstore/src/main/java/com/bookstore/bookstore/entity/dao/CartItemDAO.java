package com.bookstore.bookstore.entity.dao;

import com.bookstore.bookstore.entity.CartItem;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemDAO extends CrudRepository<CartItem, Long> {
     List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
     List<CartItem> findByOrder(Order order);

}
