package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfața care definește repository-ul pentru entitatea Category.
 * Extinde CrudRepository pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) oferite de Spring Data JPA.
 */
public interface CategoryRepo extends CrudRepository<Category, Long> {

    /**
     * Găsește o categorie după ID-ul său.
     *
     * @param id ID-ul categoriei căutate.
     * @return Categoria găsită sau null dacă nu există nicio categorie cu ID-ul specificat.
     */
    Category findById(Integer id);

    /**
     * Găsește o categorie după numele său.
     *
     * @param name Numele categoriei căutate.
     * @return Categoria găsită sau null dacă nu există nicio categorie cu numele specificat.
     */
    Category findByName(String name);
}
