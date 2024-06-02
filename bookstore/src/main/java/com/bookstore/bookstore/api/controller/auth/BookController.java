package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.serviceImpl.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Random;

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
     *
     * @return The inserted BookData object.
     */
    @PostMapping("/insert")
    public void insertBook(@RequestParam("title") String title,
                           @RequestParam("author") String author,
                           @RequestParam("category") Integer category_fk,
                           @RequestParam("description") String description,
                           @RequestParam("price") Integer price,
                           @RequestParam("stock") Integer stock,
                           @RequestParam("image") MultipartFile image) {
        BookData bookData = new BookData();
        bookData.setTitle(title);
        bookData.setAuthor(author);
        bookData.setCategory_fk(category_fk);
        bookData.setDescription(description);
        bookData.setPrice(price);
        bookData.setStock(stock);
        bookData.setImageFile(image);
        this.bookService.insertBook(bookData);
    }

    /**
     * Endpoint for finding a book.
     *
     * @param bookData The BookData object representing the book to be found.
     * @return The found BookData object.
     */
    @PostMapping("/find")
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
     * @return The updated BookData object.
     */
    @PutMapping("/update")
    public void updateBook(@RequestParam("title") String title,
                           @RequestParam("author") String author,
                           @RequestParam("category") Integer category_fk,
                           @RequestParam("description") String description,
                           @RequestParam("price") Integer price,
                           @RequestParam("stock") Integer stock,
                           @RequestParam("image") MultipartFile image) {
        BookData bookData = new BookData();
        bookData.setTitle(title);
        bookData.setAuthor(author);
        bookData.setCategory_fk(category_fk);
        bookData.setDescription(description);
        bookData.setPrice(price);
        bookData.setStock(stock);
        bookData.setImageFile(image);
        this.bookService.updateBook(bookData);
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

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return the book with the specified ID
     */
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.findBookById(id);
    }

    /**
     * Retrieves a random book.
     *
     * @return the book
     */
    @GetMapping("/random")
    public Book getRandomBook() {
        Book randomBook = bookService.getRandomBook();
        if (randomBook == null) {
            throw new RuntimeException("No books available");
        }
        return randomBook;
    }

    /**
     * Retrieves a list of books that match the given criteria of title, author
     *
     * @param bookData the data representing the criteria for searching books
     * @return a list of books that match the specified criteria
     */
    @GetMapping("/findByTitleAuthor")
    public Book findByTitleAuthor(@RequestBody BookData bookData) {
        return bookService.findByTitleAuthor(bookData);
    }

    /**
     * Endpoint for updating the stock.
     *
     * @return The updated BookData object.
     */
    @PutMapping("/updateStock")
    public ResponseEntity<String> updateStock(@RequestBody Map<String, Integer> stockUpdates) {
        try {
            bookService.updateStock(stockUpdates);
            return ResponseEntity.ok("Stock updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating stock: " + e.getMessage());
        }
    }

}
