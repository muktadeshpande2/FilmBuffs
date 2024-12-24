package com.example.FilmBuffs.controller;

import com.example.FilmBuffs.dto.request.AddFilmRequest;
import com.example.FilmBuffs.dto.request.DeleteFilmRequest;
import com.example.FilmBuffs.dto.response.FilmResponse;
import com.example.FilmBuffs.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("film")
public class FilmController {

    @Autowired
    FilmService filmService;

    //add, update, delete api
    //api to search film by title and genre

    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateFilm(@RequestBody @Valid AddFilmRequest addFilmRequest) {
        filmService.addOrUpdateFilm(addFilmRequest.toFilm());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Film Added Successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFilm(@RequestBody @Valid DeleteFilmRequest deleteFilmRequest) {
        filmService.deleteFilm(deleteFilmRequest.toFilm());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Film Deleted Successfully");
    }

    @GetMapping("/search/title")
    public ResponseEntity<FilmResponse> getFilmByTitle(@RequestParam String title) {
        return new ResponseEntity<> (filmService.findFilmByTitle(title).toFilmResponse(), HttpStatus.FOUND);
    }


    @GetMapping("/search/genre")
    public ResponseEntity<FilmResponse> getFilmByGenre(@RequestParam String genre) {
        return new ResponseEntity<> (filmService.findFilmByGenre(genre).toFilmResponse(), HttpStatus.FOUND);
    }
}
