package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);
    Book findByAuthor(String author);
    Book findByCategory(Category category);
}
