package com.example.FilmBuffs.dao;

import com.example.FilmBuffs.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
