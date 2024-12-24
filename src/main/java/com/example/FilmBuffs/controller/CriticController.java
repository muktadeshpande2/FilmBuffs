package com.example.FilmBuffs.controller;

import com.example.FilmBuffs.dto.request.CreateCriticRequest;
import com.example.FilmBuffs.dto.response.CriticResponse;
import com.example.FilmBuffs.service.CriticService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/critic")
public class CriticController {

    @Autowired
    CriticService criticService;

    //add, update, get, delete a film critic

    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateCritic(@RequestBody @Valid CreateCriticRequest createCriticRequest) {
        criticService.addOrUpdateCritic(createCriticRequest.toCritic());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Critic Profile Created Successfully");
    }

    @GetMapping("/fetch")
    public CriticResponse fetchCriticProfile(@RequestParam Integer criticId) {
        return criticService.fetchCriticProfile(criticId).toCriticResponse();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCriticProfile(@RequestParam Integer criticId) {
         criticService.deleteCriticProfile(criticId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Critic Profile Deleted Successfully");
    }
}
