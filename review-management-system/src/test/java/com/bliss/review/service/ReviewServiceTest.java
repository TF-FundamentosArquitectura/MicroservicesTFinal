package com.bliss.review.service;

import com.bliss.review.reviewmanagementsystem.ReviewManagementSystemApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bliss.review.model.Review;
import com.bliss.review.repository.ReviewRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReviewManagementSystemApplication.class)  // Especifica la clase principal
public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void testCreateReview() {
        Review review = new Review();
        review.setAppointmentId(1L);
        review.setRating(5);
        review.setComment("Excellent service");

        Mockito.when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        Review createdReview = reviewService.createReview(review);

        assertNotNull(createdReview);
        assertEquals("Excellent service", createdReview.getComment());
        assertEquals(5, createdReview.getRating());
    }

    @Test
    public void testGetReview() {
        Review review = new Review();
        review.setAppointmentId(1L);
        review.setRating(5);
        review.setComment("Excellent service");

        Mockito.when(reviewRepository.findById(1L)).thenReturn(java.util.Optional.of(review));

        Review fetchedReview = reviewService.getReview(1L);

        assertNotNull(fetchedReview);
        assertEquals("Excellent service", fetchedReview.getComment());
    }
}
