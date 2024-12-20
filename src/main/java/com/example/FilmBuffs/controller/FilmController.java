package com.example.FilmBuffs.controller;

import com.example.FilmBuffs.dto.response.FilmResponse;
import com.example.FilmBuffs.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("film")
public class FilmController {

    @Autowired
    FilmService filmService;

    //api to search film by title and genre

    @GetMapping("/search/title")
    public ResponseEntity<FilmResponse> getFilmByTitle(@RequestParam String title) {
        return new ResponseEntity<> (filmService.findFilmByTitle(title).toFilmResponse(), HttpStatus.FOUND);
    }


    @GetMapping("/search/genre")
    public ResponseEntity<FilmResponse> getFilmByGenre(@RequestParam String genre) {
        return new ResponseEntity<> (filmService.findFilmByGenre(genre).toFilmResponse(), HttpStatus.FOUND);
    }
}
