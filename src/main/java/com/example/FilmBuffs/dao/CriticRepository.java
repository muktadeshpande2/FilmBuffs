package com.example.FilmBuffs.dao;

import com.example.FilmBuffs.model.Critic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriticRepository extends CrudRepository<Critic, Integer> {
}
