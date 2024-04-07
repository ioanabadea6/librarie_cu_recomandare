package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import com.bookstore.bookstore.ObserverDesignPattern.Subject;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService, Subject {
    private BookRepo bookRepo;
    private List<Observer> observers;

    /**
     * Constructs a new BookServiceImpl with the given BookRepo.
     *
     * @param bookRepo The repository for Book entities.
     */
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
        this.observers = new ArrayList<>();
        List<Book> books= bookRepo.findAll();
        for(Book book : books){
            this.attach(book);
        }
    }

    @Override
    public Book insertBook(BookData bookData) {
        Book book = new Book();
        book.setTitle(bookData.getTitle());
        book.setAuthor(bookData.getAuthor());
        Category category = bookData.getCategory();
        book.setCategory(category);
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
        this.notifyObservers(this.createNotifyMessage(bookData));
        return bookRepo.save(book);
    }

    @Override
    public Book findBook(BookData bookData) {
        Book book = new Book();
        book = bookRepo.findByTitle(bookData.getTitle());
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
    public String createNotifyMessage(BookData bookdata) {
        String message = "Cartea cu titlul ";
        message += bookdata.getTitle();
        message += "si-a modificat pretul in " + bookdata.getPrice();
        return message;
    }

}


