package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);

    List<Book> findByCategory(String category);

    List<Book> blurrySearch(String title);
}
