package com.example.FilmBuffs.controller;

import com.example.FilmBuffs.dto.request.CreateAdminRequest;
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

    @PostMapping("/create")
    public ResponseEntity<String>createOrUpdateAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest) {

        try{
            adminService.createOrUpdateAdmin(createAdminRequest.toAdmin());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Admin got created successfully");

        } catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
