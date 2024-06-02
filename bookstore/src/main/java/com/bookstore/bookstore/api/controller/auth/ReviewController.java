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

    @PostMapping("/insert")
    public Review insert(@RequestBody ReviewData reviewData){
        return reviewService.insert(reviewData);
    }

    @DeleteMapping("/delete")
    public Review delete(@RequestBody ReviewData reviewData){
        return reviewService.delete(reviewData);
    }

    @PostMapping("/getReviews")
    public List<Review> findBooksReview(@RequestBody BookTitleData bookTitleData){
        return reviewService.findBooksReview(bookTitleData);
    }
}
