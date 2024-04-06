package com.bookstore.bookstore.entity.dao;

import com.bookstore.bookstore.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartDAO extends CrudRepository<ShoppingCart, Long> {
}
