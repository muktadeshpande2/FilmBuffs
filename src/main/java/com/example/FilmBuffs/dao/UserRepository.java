package com.example.FilmBuffs.dao;

import com.example.FilmBuffs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
