package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.model.CategoryData;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.serviceImpl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @PostMapping("/insert")
    public CategoryData insertCategory(@RequestBody CategoryData categoryData) {
        this.categoryServiceImpl.insertCategory(categoryData);
        return categoryData;
    }

    @GetMapping("/find")
    public CategoryData findCategory(@RequestBody CategoryData categoryData){
        this.categoryServiceImpl.findCategory(categoryData);
        return categoryData;
    }


    @DeleteMapping("/delete")
    public void deleteCategory(@RequestBody CategoryData categoryData){
        this.categoryServiceImpl.deleteCategory(categoryData);
    }


    @PutMapping("/update")
    public CategoryData updateCategory(@RequestBody CategoryData categoryData) {
        this.categoryServiceImpl.updateCategory(categoryData);
        return categoryData;
    }
}
