package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category,Long> {
    Category findById(Integer id);
    Category findByName(String name);
}
