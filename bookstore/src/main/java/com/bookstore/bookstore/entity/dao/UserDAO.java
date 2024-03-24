package com.bookstore.bookstore.entity.dao;

import com.bookstore.bookstore.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Data Access Object for the LocalUser data.
 */
public interface UserDAO extends CrudRepository<User, Long> {
    Optional<User> findByUsernameIgnoreCase(String username);

    Optional<User> findByEmailIgnoreCase(String email);
}
