package com.example.heroes.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
    
    List<Local> findByNombreLocal(String nombreLocal);

}