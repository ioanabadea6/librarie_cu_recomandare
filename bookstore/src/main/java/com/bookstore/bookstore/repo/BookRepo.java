package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfața care definește repository-ul pentru entitatea Book.
 * Extinde JpaRepository pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) oferite de Spring Data JPA.
 */
public interface BookRepo extends JpaRepository<Book, Integer> {

    /**
     * Caută o carte după titlul său.
     *
     * @param title Titlul cărții căutate.
     * @return Cartea găsită sau null dacă nu există nicio carte cu titlul specificat.
     */
    Book findByTitle(String title);

    /**
     * Caută o carte după autorul său.
     *
     * @param author Autorul cărții căutate.
     * @return Cartea găsită sau null dacă nu există nicio carte cu autorul specificat.
     */
    Book findByAuthor(String author);

    /**
     * Caută o carte după categoria sa.
     *
     * @param category Categoria cărții căutate.
     * @return Cartea găsită sau null dacă nu există nicio carte în categoria specificată.
     */
    Book findByCategory(Category category);
}
