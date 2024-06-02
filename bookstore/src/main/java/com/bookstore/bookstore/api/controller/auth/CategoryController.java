package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.CategoryData;
import com.bookstore.bookstore.serviceImpl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing category-related operations.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceImpl categoryServiceImpl;

    /**
     * Constructor for CategoryController.
     *
     * @param categoryServiceImpl The CategoryServiceImpl instance to be used for category operations.
     */
    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    /**
     * Endpoint for inserting a new category.
     *
     * @param categoryData The CategoryData object representing the category to be inserted.
     * @return The inserted CategoryData object.
     */
    @PostMapping("/insert")
    public CategoryData insertCategory(@RequestBody CategoryData categoryData) {
        this.categoryServiceImpl.insertCategory(categoryData);
        return categoryData;
    }

    /**
     * Endpoint for finding a category.
     *
     * @param categoryData The CategoryData object representing the category to be found.
     * @return The found CategoryData object.
     */
    @GetMapping("/find")
    public CategoryData findCategory(@RequestBody CategoryData categoryData) {
        this.categoryServiceImpl.findCategory(categoryData);
        return categoryData;
    }

    /**
     * Endpoint for finding a category by name.
     *
     * @param categoryData The CategoryData object representing the category to be found.
     * @return The found CategoryData object.
     */
    @PostMapping("/findByName")
    public CategoryData findCategoryByName(@RequestBody CategoryData categoryData) {
        this.categoryServiceImpl.findCategoryByName(categoryData);
        return categoryData;
    }

    /**
     * Endpoint for deleting a category.
     *
     * @param categoryData The CategoryData object representing the category to be deleted.
     */
    @DeleteMapping("/delete")
    public Category deleteCategory(@RequestBody CategoryData categoryData) {
        return this.categoryServiceImpl.deleteCategory(categoryData);
    }

    /**
     * Endpoint for updating a category.
     *
     * @param categoryData The CategoryData object representing the category to be updated.
     * @return The updated CategoryData object.
     */
    @PutMapping("/update")
    public CategoryData updateCategory(@RequestBody CategoryData categoryData) {
        this.categoryServiceImpl.updateCategory(categoryData);
        return categoryData;
    }

    @GetMapping("/findAll")
    public List<Category> findAll(){
        return this.categoryServiceImpl.findAll();
    }
}
