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

    /**
     * Inserts a new category into the system.
     *
     * @param categoryData the data of the category to be inserted
     * @return the inserted category
     */
    @Override
    public Category insertCategory(CategoryData categoryData) {
        Category category = new Category();
        category.setName(categoryData.getName());
        return categoryRepo.save(category);
    }

    /**
     * Deletes a category from the system.
     *
     * @param categoryData the data of the category to be deleted
     */
    @Override
    public Category deleteCategory(CategoryData categoryData) {
        Category category = new Category();
        category = findCategory(categoryData);
        categoryRepo.delete(category);
        return category;
    }

    /**
     * Updates an existing category in the system.
     *
     * @param categoryData the new data for the category
     * @return the updated category
     */
    @Override
    public Category updateCategory(CategoryData categoryData) {
        Category category = findCategory(categoryData);
        category.setName(categoryData.getName());
        return categoryRepo.save(category);
    }

    /**
     * Finds a category by its unique identifier.
     *
     * @param categoryData the data of the category to be found
     * @return the found category, or null if not found
     */
    @Override
    public Category findCategory(CategoryData categoryData) {
        Category category = new Category();
        category = categoryRepo.findById(categoryData.getId());
        return category;
    }
}
