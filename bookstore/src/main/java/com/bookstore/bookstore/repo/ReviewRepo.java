package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
