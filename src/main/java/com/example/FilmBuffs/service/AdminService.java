package com.example.FilmBuffs.service;

import com.example.FilmBuffs.dao.AdminRepository;
import com.example.FilmBuffs.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void createOrUpdateAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
