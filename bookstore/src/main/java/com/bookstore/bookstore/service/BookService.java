package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.model.BookData;

import java.util.List;

/**
 * Interfața pentru serviciul de gestionare a cărților.
 */
public interface BookService {

    /**
     * Inserează o carte în sistem.
     *
     * @param bookData Informațiile despre carte care urmează să fie inserată.
     * @return Cartea inserată.
     */
    Book insertBook(BookData bookData);

    /**
     * Șterge o carte din sistem.
     *
     * @param bookData Informațiile despre carte care urmează să fie ștearsă.
     */
    void deleteBook(BookData bookData);

    /**
     * Actualizează informațiile unei cărți în sistem.
     *
     * @param bookData Informațiile actualizate ale cărții.
     * @return Cartea actualizată.
     */
    Book updateBook(BookData bookData);

    /**
     * Găsește o carte în sistem pe baza informațiilor furnizate.
     *
     * @param bookData Informațiile despre carte utilizate pentru căutare.
     * @return Cartea găsită sau null dacă nu a fost găsită nicio carte.
     */
    Book findBook(BookData bookData);

    /**
     * Returnează o listă cu toate cărțile din sistem.
     *
     * @return Lista de cărți din sistem.
     */
    List<Book> findAll();

    /**
     * Retrieves a list of books that match the given criteria of title, price, author, and category.
     *
     * @param bookData the data representing the criteria for searching books
     * @return a list of books that match the specified criteria
     */
    List<Book> findByTitlePriceAuthorAndCategory(BookData bookData);
}
