package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.Review;
import com.bookstore.bookstore.model.BookTitleData;
import com.bookstore.bookstore.model.ReviewData;
import com.bookstore.bookstore.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Inserts a new review into the database.
     *
     * @param reviewData The ReviewData object containing review details.
     * @return The inserted Review object.
     */
    @PostMapping("/insert")
    public Review insert(@RequestBody ReviewData reviewData){
        return reviewService.insert(reviewData);
    }

    /**
     * Deletes a review from the database.
     *
     * @param reviewData The ReviewData object containing review details.
     * @return The deleted Review object.
     */
    @DeleteMapping("/delete")
    public Review delete(@RequestBody ReviewData reviewData){
        return reviewService.delete(reviewData);
    }

    /**
     * Retrieves reviews associated with a specific book title.
     *
     * @param bookTitleData The BookTitleData object containing the book title.
     * @return A list of Review objects associated with the specified book title.
     */
    @PostMapping("/getReviews")
    public List<Review> findBooksReview(@RequestBody BookTitleData bookTitleData){
        return reviewService.findBooksReview(bookTitleData);
    }
}
