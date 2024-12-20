package com.example.FilmBuffs.dto.request;

import com.example.FilmBuffs.model.Review;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddReviewRequest {

    @NotNull
    private Long filmId;

    @NotBlank
    private String review;

    @NotNull
    private Double rating;


    public Review toReview() {
        return Review.builder()
                .id(this.filmId)
                .filmReview(this.review)
                .rating(this.rating)
                .build();
    }

}
