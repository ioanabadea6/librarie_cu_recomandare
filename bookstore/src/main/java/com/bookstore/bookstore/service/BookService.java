package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.model.UserData;

import java.util.List;

public interface BookService {
    public Book insertBook(BookData bookData);

    public void deleteBook(BookData bookData);

    public Book updateBook(BookData bookData);

    public Book findBook(BookData bookData);

}
