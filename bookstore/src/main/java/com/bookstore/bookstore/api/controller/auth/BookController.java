package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

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
}
