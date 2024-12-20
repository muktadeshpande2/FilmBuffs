package com.example.FilmBuffs.controller;

import com.example.FilmBuffs.dto.request.AddReviewRequest;
import com.example.FilmBuffs.dto.response.ReviewResponse;
import com.example.FilmBuffs.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    //add, update, get, delete review
    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateReview(@RequestBody @Valid AddReviewRequest addReviewRequest) {
        reviewService.addOrUpdateReview(addReviewRequest.toReview());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Review Added Successfully");
    }


    @GetMapping("/find")
    public ReviewResponse findReview(@RequestParam Long reviewId) {
        return reviewService.findReview(reviewId).toReviewResponse();

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReview(@RequestParam Long reviewId) {
        reviewService.deleteReview(reviewId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Review Deleted Successfully");
    }
}
