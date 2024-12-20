package com.example.FilmBuffs.service;

import com.example.FilmBuffs.dao.FilmRepository;
import com.example.FilmBuffs.dao.ReviewRepository;
import com.example.FilmBuffs.model.Film;
import com.example.FilmBuffs.model.Review;
import org.springframework.beans.factory.annotation.Autowired;


public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    FilmRepository filmRepository;

    public void addOrUpdateReview(Review review) {
        Film film = filmRepository.findById(review.getFilm().getId()).orElse(null);
        reviewRepository.save(review);

        if(film != null) {
            Double average = reviewRepository.getReviewAverage(film.getId());
            film.setRating(average);
            filmRepository.save(film);
        }
    }

    public Review findReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);

        assert review != null;
        Film film = filmRepository.findById(review.getFilm().getId()).orElse(null);
        reviewRepository.deleteById(reviewId);

        if(film != null) {
            Double average = reviewRepository.getReviewAverage(film.getId());
            film.setRating(average);
            filmRepository.save(film);
        }
    }
}
