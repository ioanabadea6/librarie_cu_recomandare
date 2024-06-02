package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.model.CategoryData;
import com.bookstore.bookstore.repo.CategoryRepo;
import com.bookstore.bookstore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        category = findCategoryByName(categoryData);
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
        if(category != null){
            category.setName(categoryData.getName());
        }
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
        if(category != null){
            return category;
        }
        else{
            return null;
        }
    }

    /**
     * Caută o categorie în baza de date după numele său.
     *
     * @param categoryData Obiectul care conține datele categoriei pentru căutare.
     * @return Categorie găsită sau {@code null} dacă nu există o categorie cu numele respectiv.
     */
    @Override
    public Category findCategoryByName(CategoryData categoryData) {
        Category category = new Category();
        category = categoryRepo.findByName(categoryData.getName());
        if(category != null){
            return category;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Category> findAll(){
        return categoryRepo.findAll();
    }
}
