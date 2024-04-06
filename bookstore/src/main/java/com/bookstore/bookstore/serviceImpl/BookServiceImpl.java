package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book insertBook(BookData bookData) {
        Book book = new Book();
        book.setTitle(bookData.getTitle());
        book.setAuthor(bookData.getAuthor());
        book.setCategory(bookData.getCategory());
        book.setDescription(bookData.getDescription());
        book.setPrice(bookData.getPrice());
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(BookData bookData) {
        Book book = new Book();
        book = findBook(bookData);
        book.setAuthor(bookData.getAuthor());
        book.setCategory(bookData.getCategory());
        book.setDescription(bookData.getDescription());
        book.setPrice(bookData.getPrice());
        bookRepo.delete(book);
    }

    @Override
    public Book updateBook(BookData bookData) {
        Book book = findBook(bookData);
        book.setTitle(bookData.getTitle());
        book.setAuthor(bookData.getAuthor());
        book.setCategory(bookData.getCategory());
        book.setDescription(bookData.getDescription());
        book.setPrice(bookData.getPrice());
        return bookRepo.save(book);
    }

    @Override
    public Book findBook(BookData bookData) {
        Book book = new Book();
        book = bookRepo.findByTitle(bookData.getTitle());
        return book;
    }
}
