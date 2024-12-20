package com.example.FilmBuffs.dto.request;

import com.example.FilmBuffs.model.Film;
import com.example.FilmBuffs.model.Genre;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddFilmRequest {

    @NotBlank
    private String title;

    @NotBlank
    private Genre genre;

    @NotBlank
    private Date releaseDate;

    @NotBlank
    private Double length;

    public Film toFilm() {
        return Film.builder()
                .title(this.title)
                .genre(this.genre)
                .releaseDate(this.releaseDate)
                .length(this.length)
                .build();
    }
}
