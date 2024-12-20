package com.example.FilmBuffs.dao;

import com.example.FilmBuffs.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query(value = "select avg(rating) from review where film_id =?1", nativeQuery = true)
    Double getReviewAverage(Long id);
}
