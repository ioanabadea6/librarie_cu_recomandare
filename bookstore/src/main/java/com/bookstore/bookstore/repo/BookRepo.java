package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
     * Retrieves a list of books that match the given criteria of title, price, author, and category.
     *
     * @param title       the title of the book to search for
     * @param price       the price of the book to search for
     * @param author      the author of the book to search for
     * @param category_fk the foreign key representing the category of the book to search for
     * @return a list of books that match the specified criteria
     */
    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.price = :price AND b.author = :author AND b.category.id = :category_fk")
    List<Book> findByTitlePriceAuthorAndCategory(String title, Integer price, String author, Integer category_fk);

    Book findBookById(Integer id);

}
