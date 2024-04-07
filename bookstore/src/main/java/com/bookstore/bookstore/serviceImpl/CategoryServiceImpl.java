package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.model.CategoryData;
import com.bookstore.bookstore.repo.CategoryRepo;
import com.bookstore.bookstore.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;

    /**
     * Constructs a new CategoryServiceImpl with the given CategoryRepo.
     *
     * @param categoryRepo The repository for Category entities.
     */
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category insertCategory(CategoryData categoryData) {
        Category category = new Category();
        category.setName(categoryData.getName());
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(CategoryData categoryData) {
        Category category = new Category();
        category = findCategory(categoryData);
        categoryRepo.delete(category);
    }

    @Override
    public Category updateCategory(CategoryData categoryData) {
        Category category = findCategory(categoryData);
        category.setName(categoryData.getName());
        return categoryRepo.save(category);
    }

    @Override
    public Category findCategory(CategoryData categoryData) {
        Category category = new Category();
        category = categoryRepo.findById(categoryData.getId());
        return category;
    }
}
