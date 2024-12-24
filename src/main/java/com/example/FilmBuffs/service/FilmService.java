package com.example.FilmBuffs.service;

import com.example.FilmBuffs.dao.FilmRepository;
import com.example.FilmBuffs.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public void addOrUpdateFilm(Film film) {
        filmRepository.save(film);
    }

    public void deleteFilm(Film film) {
        filmRepository.deleteById(film.getId());
    }

    public Film findFilmByTitle(String title) {
        return filmRepository.findByTitle(title);

    }

    public Film findFilmByGenre(String genre) {
        return filmRepository.findByGenre(genre);
    }
}
