package com.example.FilmBuffs.service;

import com.example.FilmBuffs.dao.CriticRepository;
import com.example.FilmBuffs.model.Critic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CriticService {

    @Autowired
    CriticRepository criticRepository;

    public void addOrUpdateCritic(Critic critic) {
        criticRepository.save(critic);
    }

    public Critic fetchCriticProfile(Integer criticId) {
        return criticRepository.findById(criticId).orElse(null);
    }

    public void deleteCriticProfile(Integer criticId) {
        criticRepository.deleteById(criticId);
    }
}
