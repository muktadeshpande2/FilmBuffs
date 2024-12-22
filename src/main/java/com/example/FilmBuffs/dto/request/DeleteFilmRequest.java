package com.example.FilmBuffs.dto.request;

import com.example.FilmBuffs.model.Film;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteFilmRequest {

    private Integer filmId;

    public Film toFilm() {
        return Film.builder()
                .id(this.filmId)
                .build();
    }
}
