package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Review;
import com.bookstore.bookstore.model.BookTitleData;
import com.bookstore.bookstore.model.ReviewData;

import java.util.List;

public interface ReviewService {
    /**
     * Inserts a new review into the database.
     *
     * @param reviewData The ReviewData object containing review details.
     * @return The inserted Review object.
     */
    Review insert(ReviewData  reviewData);
    /**
     * Deletes a review from the database.
     *
     * @param reviewData The ReviewData object containing review details.
     * @return The deleted Review object.
     */
    Review delete(ReviewData reviewData);
    /**
     * Retrieves reviews associated with a specific book title.
     *
     * @param bookTitleData The BookTitleData object containing the book title.
     * @return A list of Review objects associated with the specified book title.
     */
    List<Review> findBooksReview(BookTitleData bookTitleData);
}
