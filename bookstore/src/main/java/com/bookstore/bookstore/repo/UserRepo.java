package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByName(String name);
}
