package com.bliss.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bliss.review.model.Review;
import com.bliss.review.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}
