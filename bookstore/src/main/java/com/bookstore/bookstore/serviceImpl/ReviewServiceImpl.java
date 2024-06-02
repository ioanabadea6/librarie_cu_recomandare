package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Review;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.BookTitleData;
import com.bookstore.bookstore.model.ReviewData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.ReviewRepo;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private BookRepo bookRepo;
    private ReviewRepo reviewRepo;
    private UserRepo userRepo;

    public ReviewServiceImpl(BookRepo bookRepo, ReviewRepo reviewRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
    }

    /**
     * Inserts a new review into the database based on the provided ReviewData.
     *
     * @param reviewData The ReviewData object containing review details.
     * @return The inserted Review object.
     */
    @Override
    public Review insert(ReviewData reviewData) {
        User user = userRepo.findByUsername(reviewData.getUsername());
        Book book = bookRepo.findByTitle(reviewData.getTitle());
        Review review = new Review();
        if(user != null && book != null){
            review.setUser(user);
            review.setBook(book);
            review.setRating(reviewData.getRating());
            review.setMessage(reviewData.getMessage());
        }
        return reviewRepo.save(review);
    }

    /**
     * Deletes a review from the database based on the provided ReviewData.
     *
     * @param reviewData The ReviewData object containing review details.
     * @return The deleted Review object.
     */
    @Override
    public Review delete(ReviewData reviewData) {
        User user = userRepo.findByUsername(reviewData.getUsername());
        Book book = bookRepo.findByTitle(reviewData.getTitle());
        Review review = new Review();
        if(user != null && book != null){
            review.setUser(user);
            review.setBook(book);
            review.setRating(reviewData.getRating());
            review.setMessage(reviewData.getMessage());
        }
        reviewRepo.save(review);
        return review;
    }

    /**
     * Finds all reviews associated with a specific book title.
     *
     * @param bookTitleData The BookTitleData object containing the book title.
     * @return A list of Review objects associated with the specified book title.
     */
    @Override
    public List<Review> findBooksReview(BookTitleData bookTitleData) {
        Book book = bookRepo.findByTitle(bookTitleData.getTitle());
        List<Review> reviews = new ArrayList<>();
        if( book != null){
            List<Review> reviewList = reviewRepo.findAll();
            for(Review review: reviewList){
                if(review.getBook().getTitle().equals(book.getTitle())){
                    reviews.add(review);
                }
            }
        }
        return reviews;
    }
}
