package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Comuna;

public interface ComunaRepository
        extends JpaRepository<Comuna, Integer> {

    List<Comuna> findByNombre(String nombre);

    @Query("SELECT c FROM Comuna c WHERE c.nombre LIKE %:nombre%")
    List<Comuna> buscarPorNombre(
            @Param("nombre") String nombre
    );

}