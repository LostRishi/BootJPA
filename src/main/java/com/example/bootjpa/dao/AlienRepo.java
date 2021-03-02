package com.example.bootjpa.dao;

import com.example.bootjpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {//
    // here we can write our own methods
//    List<alien> findByTech(String tech);
//    List<alien> findByAidGreaterThan(int aid);
}
