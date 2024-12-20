package com.example.FilmBuffs.service;

import com.example.FilmBuffs.dao.FilmRepository;
import com.example.FilmBuffs.model.Film;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public Film findFilmByTitle(String title) {
        return filmRepository.findByTitle(title);

    }

    public Film findFilmByGenre(String genre) {
        return filmRepository.findByGenre(genre);
    }
}
