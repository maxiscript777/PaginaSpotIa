package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Local;

public interface LocalRepository
        extends JpaRepository<Local, Integer> {

    List<Local> findByNombre(String nombre);

    @Query("SELECT l FROM Local l WHERE l.capacidad >= :capacidad")
    List<Local> buscarLocalesGrandes(
            @Param("capacidad") Integer capacidad
    );

}