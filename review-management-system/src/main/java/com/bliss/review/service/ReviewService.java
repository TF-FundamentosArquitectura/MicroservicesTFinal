package com.bliss.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bliss.review.repository.ReviewRepository;
import com.bliss.review.model.Review;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        review.setCreatedDate(LocalDateTime.now());  // Establece la fecha de creación automáticamente
        return reviewRepository.save(review);
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
