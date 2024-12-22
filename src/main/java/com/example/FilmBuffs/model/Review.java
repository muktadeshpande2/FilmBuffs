package com.example.FilmBuffs.model;

import com.example.FilmBuffs.dto.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String filmTitle;

    private Double rating;  //rating dedicated to each review

    private String filmReview;

    @ManyToOne
    @JoinColumn(name="film_id", nullable=false)
    @JsonIgnore
    private Film film;

    @ManyToOne
    @JoinColumn(name = "critic_id", nullable = false)
    @JsonIgnore
    private Critic critic;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


    public ReviewResponse toReviewResponse() {
        return ReviewResponse.builder()
                .review(this.filmReview)
                .build();
    }
}
