package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.serviceImpl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping("/insert")
    public BookData insertBook(@RequestBody BookData bookData) {
        this.bookServiceImpl.insertBook(bookData);
        return bookData;
    }


    @GetMapping("/find")
    public BookData findBook(@RequestBody BookData bookData){
        this.bookServiceImpl.findBook(bookData);
        return bookData;
    }


    @DeleteMapping("/delete")
    public void deleteBook(@RequestBody BookData bookData){
        this.bookServiceImpl.deleteBook(bookData);
    }


    @PutMapping("/update")
    public BookData updateBook(@RequestBody BookData bookData) {
        this.bookServiceImpl.updateBook(bookData);
        return bookData;
    }
}
