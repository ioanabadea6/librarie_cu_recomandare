package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.model.CategoryData;
import com.bookstore.bookstore.repo.CategoryRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepo categoryRepoMock;
    private CategoryServiceImpl categoryServiceImplTest;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the mocks using MockitoAnnotations and creates an instance of CategoryServiceImpl
     * with the mocked CategoryRepo.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        categoryServiceImplTest = new CategoryServiceImpl(categoryRepoMock);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.CategoryServiceImpl#insertCategory(CategoryData)} method.
     * Verifies that the category repository's save method is called with the expected category when inserting a category.
     */
    @Test
    public void insertCategoryTest(){
        CategoryData categoryData = new CategoryData();
        Category category = new Category();
        categoryServiceImplTest.insertCategory(categoryData);
        verify(categoryRepoMock).save(category);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.CategoryServiceImpl#deleteCategory(CategoryData)} method.
     * Verifies that the category repository's delete method is called with the expected category when deleting a category.
     */
    @Test
    public void deleteCategoryTest(){
        CategoryData categoryData = new CategoryData();
        Category category = categoryServiceImplTest.deleteCategory(categoryData);
        verify(categoryRepoMock).delete(category);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.CategoryServiceImpl#updateCategory(CategoryData)} method.
     * Verifies that the category repository's findById method is called with the expected category ID when updating a category.
     */
    @Test
    public void updateCategoryTest(){
        CategoryData categoryData = new CategoryData();
        categoryData.setId(1);
        categoryData.setName("New Category Name");

        Category existingCategory = new Category();
        existingCategory.setId(1);
        existingCategory.setName("Old Category Name");

        when(categoryRepoMock.findById(1)).thenReturn(existingCategory);

        Category updatedCategory = new Category();
        updatedCategory.setId(1);
        updatedCategory.setName("New Category Name");

        Category result = categoryServiceImplTest.updateCategory(categoryData);

        verify(categoryRepoMock).findById(1);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.CategoryServiceImpl#findCategory(CategoryData)} method.
     * Verifies that the category repository's findById method is called with the expected category ID when finding a category.
     */
    @Test
    public void findCategoryTest(){
        CategoryData categoryData = new CategoryData();
        categoryServiceImplTest.findCategory(categoryData);
        verify(categoryRepoMock).findById(categoryData.getId());
    }
}
