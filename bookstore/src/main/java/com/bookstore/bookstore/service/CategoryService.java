package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.model.CategoryData;

public interface CategoryService {
    public Category insertCategory(CategoryData categoryData);

    public void deleteCategory(CategoryData categoryData);

    public Category updateCategory(CategoryData categoryData);

    public Category findCategory(CategoryData categoryData);
}
