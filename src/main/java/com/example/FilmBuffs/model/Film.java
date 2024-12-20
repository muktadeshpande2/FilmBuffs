package com.example.FilmBuffs.model;

import com.example.FilmBuffs.dto.response.FilmResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;  //a single entity which is average rating of all the reviews for a movie

    @OneToMany(mappedBy = "film")
    private List<Review> reviewList; //mappedBy indicates the field-name that maps the movie with all its reviews

    private Date releaseDate;

    private Double length;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


    public FilmResponse toFilmResponse() {
        return FilmResponse.builder()
                .title(this.title)
                .build();
    }
}
