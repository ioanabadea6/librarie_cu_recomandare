package com.bookstore.bookstore.entity.dao;

import com.bookstore.bookstore.entity.CartItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookToCartItemDAO extends CrudRepository<CartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
