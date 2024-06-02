package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepo extends JpaRepository<Wishlist, Long> {
    /**
     * Find a wishlist by user.
     * @param user
     * @return
     */
    List<Wishlist> findByUser(User user);
}
