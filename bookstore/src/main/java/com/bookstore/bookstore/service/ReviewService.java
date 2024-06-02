package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Review;
import com.bookstore.bookstore.model.BookTitleData;
import com.bookstore.bookstore.model.ReviewData;

import java.util.List;

public interface ReviewService {
    Review insert(ReviewData  reviewData);
    Review delete(ReviewData reviewData);
    List<Review> findBooksReview(BookTitleData bookTitleData);
}
