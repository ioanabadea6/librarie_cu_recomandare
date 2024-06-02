package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import com.bookstore.bookstore.ObserverDesignPattern.Subject;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.CategoryRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class BookServiceImpl implements BookService, Subject {
    private BookRepo bookRepo;
    private List<Observer> observers;
    private CategoryRepo categoryRepo;

    private Random random = new Random();

    /**
     * Constructs a new instance of BookServiceImpl with the specified BookRepo and CategoryRepo.
     * Additionally, initializes the list of observers and attaches all existing books to them.
     *
     * @param bookRepo     the repository for managing books
     * @param categoryRepo the repository for managing categories
     */
    public BookServiceImpl(BookRepo bookRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
        this.observers = new ArrayList<>();
//        List<Book> books = bookRepo.findAll();
//        for(Book book : books){
//            this.attach(book);
//        }
    }

    /**
     * Inserts a new book into the system.
     *
     * @param bookData the data of the book to be inserted
     * @return the inserted book
     */
    @Override
    public Book insertBook(BookData bookData) {
        Book book = new Book();
        book.setTitle(bookData.getTitle());
        book.setAuthor(bookData.getAuthor());
        book.setCategory(categoryRepo.findById(bookData.getCategory_fk()));
        book.setDescription(bookData.getDescription());
        book.setPrice(bookData.getPrice());
        book.setStock(bookData.getStock());
        try {
            book.setImage(bookData.getImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.attach(book);
        bookRepo.save(book);
        return book;
    }

    /**
     * Deletes a book from the system.
     *
     * @param bookData the data of the book to be deleted
     */
    @Override
    public Book deleteBook(BookData bookData) {
        Book book = new Book();
        book = findBook(bookData);
        bookRepo.delete(book);
        return book;
    }

    /**
     * Updates an existing book in the system.
     *
     * @param bookData the new data for the book
     * @return the updated book
     */
    @Override
    public Book updateBook(BookData bookData) {
        Book book = findBook(bookData);
        book.setTitle(bookData.getTitle());
        book.setAuthor(bookData.getAuthor());
        book.setCategory(categoryRepo.findById(bookData.getCategory_fk()));
        book.setDescription(bookData.getDescription());
        Integer oldPrice = book.getPrice();
        Integer newPrice = bookData.getPrice();
        if(!Objects.equals(oldPrice, newPrice)){
            book.setPrice(bookData.getPrice());
            this.notifyObservers(this.createNotifyMessagePrice(bookData));
        }
        Integer oldStock = book.getStock();
        Integer newStock = bookData.getStock();
        if(!Objects.equals(oldStock, newStock)){
            book.setStock(bookData.getStock());
            this.notifyObservers(this.createNotifyMessageStock(bookData));
        }
        return bookRepo.save(book);
    }

    /**
     * Finds a book by its title.
     *
     * @param bookData the data of the book to be found
     * @return the found book
     */
    @Override
    public Book findBook(BookData bookData) {
        Book book = new Book();
        book = bookRepo.findByTitle(bookData.getTitle());
        return book;
    }

    /**
     * Retrieves all books from the system.
     *
     * @return a list of all books
     */
    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    /**
     * Retrieves a list of books that match the given criteria of title, price, author, and category.
     *
     * @param bookData the data representing the criteria for searching books
     * @return a list of books that match the specified criteria
     */
    @Override
    public List<Book> findByTitlePriceAuthorAndCategory(BookData bookData) {
        return bookRepo.findByTitlePriceAuthorAndCategory(bookData.getTitle(), bookData.getPrice(), bookData.getAuthor(), bookData.getCategory_fk());
    }

    /**
     * Attaches an observer to the list of observers.
     *
     * @param observer the observer to be attached
     */
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Detaches an observer from the list of observers.
     *
     * @param observer the observer to be detached
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers with the given message.
     *
     * @param msg the message to be sent to observers
     */
    @Override
    public void notifyObservers(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }

    /**
     * Creates a notification message for a price change.
     *
     * @param bookdata the data of the book with the price change
     * @return the notification message
     */
    public String createNotifyMessagePrice(BookData bookdata) {
        String message = "Cartea si-a modificat pretul in " + bookdata.getPrice();
        return message;
    }

    /**
     * Creates a notification message for a stock change.
     *
     * @param bookdata the data of the book with the stock change
     * @return the notification message
     */
    public String createNotifyMessageStock(BookData bookdata) {
        String message = "Cartea si-a modificat stocul in " + bookdata.getStock();
        return message;
    }

    /**
     * Gaseste o carte dupa id
     * @param id
     * @return
     */
    @Override
    public Book findBookById(Integer id) {
        return bookRepo.findById(id).orElse(null);
    }

    /**
     * genereaza o carte random
     * @return
     */
    @Override
    public Book getRandomBook() {
        List<Book> books = bookRepo.findAll();
        if (books.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(books.size());
        return books.get(randomIndex);
    }

    /**
     * gaseste cartea dupa titlu si autor
     * @param bookData
     * @return
     */
    @Override
    public Book findByTitleAuthor(BookData bookData) {
        return bookRepo.findByTitleAuthor(bookData.getTitle(), bookData.getAuthor());
    }

    /**
     * modifica stocul atunci cand se plaseaza o comanda
     * @param stockUpdates
     */
    public void updateStock(Map<String, Integer> stockUpdates) {
        for (Map.Entry<String, Integer> entry : stockUpdates.entrySet()) {
            Integer bookId = Integer.valueOf(entry.getKey());
            Integer newStock = entry.getValue();
            Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
            book.setStock(newStock);
            bookRepo.save(book);
        }
    }

}


