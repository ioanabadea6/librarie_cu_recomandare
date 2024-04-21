package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing book-related operations.
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    /**
     * Constructor for BookController.
     *
     * @param bookService The BookService instance to be used for book operations.
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Endpoint for inserting a new book.
     *
     * @param bookData The BookData object representing the book to be inserted.
     * @return The inserted BookData object.
     */
    @PostMapping("/insert")
    public BookData insertBook(@RequestBody BookData bookData) {
        this.bookService.insertBook(bookData);
        return bookData;
    }

    /**
     * Endpoint for finding a book.
     *
     * @param bookData The BookData object representing the book to be found.
     * @return The found BookData object.
     */
    @GetMapping("/find")
    public BookData findBook(@RequestBody BookData bookData) {
        this.bookService.findBook(bookData);
        return bookData;
    }

    /**
     * Endpoint for deleting a book.
     *
     * @param bookData The BookData object representing the book to be deleted.
     */
    @DeleteMapping("/delete")
    public void deleteBook(@RequestBody BookData bookData) {
        this.bookService.deleteBook(bookData);
    }

    /**
     * Endpoint for updating a book.
     *
     * @param bookData The BookData object representing the book to be updated.
     * @return The updated BookData object.
     */
    @PutMapping("/update")
    public BookData updateBook(@RequestBody BookData bookData) {
        this.bookService.updateBook(bookData);
        return bookData;
    }

    /**
     * Retrieves all books available in the system.
     *
     * @return a list of all books
     */
    @GetMapping("/findAll")
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    /**
     * Retrieves a list of books that match the given criteria of title, price, author, and category.
     *
     * @param bookData the data representing the criteria for searching books
     * @return a list of books that match the specified criteria
     */
    @GetMapping("/findByTitlePriceAuthorAndCategory")
    public List<Book> findByTitlePriceAuthorAndCategory(@RequestBody BookData bookData) {
        return this.bookService.findByTitlePriceAuthorAndCategory(bookData);
    }
}
