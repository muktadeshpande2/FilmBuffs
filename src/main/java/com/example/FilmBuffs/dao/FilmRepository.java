package com.example.FilmBuffs.dao;

import com.example.FilmBuffs.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

    Film findByTitle(String title);

    Film findByGenre(String genre);
}
