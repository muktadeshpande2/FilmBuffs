package com.example.FilmBuffs.controller;

import com.example.FilmBuffs.dto.request.DeleteFilmRequest;
import com.example.FilmBuffs.dto.request.AddFilmRequest;
import com.example.FilmBuffs.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    //add, update, delete api

    @PostMapping("/film/add")
    public ResponseEntity<String> addOrUpdateFilm(@RequestBody @Valid AddFilmRequest addFilmRequest) {
         adminService.addOrUpdateFilm(addFilmRequest.toFilm());

         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body("Film Added Successfully");
    }

    @DeleteMapping("/film/delete")
    public ResponseEntity<String> deleteFilm(@RequestBody @Valid DeleteFilmRequest deleteFilmRequest) {
        adminService.deleteFilm(deleteFilmRequest.toFilm());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Film Deleted Successfully");
    }
}
