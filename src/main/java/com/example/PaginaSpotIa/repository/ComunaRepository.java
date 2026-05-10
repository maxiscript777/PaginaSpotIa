package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Comuna;

public interface comunaRepository
        extends JpaRepository<Comuna, Integer> {

    // Buscar por nombre exacto
    List<Comuna> findByNombre(String nombre);

    // Buscar por coincidencia parcial
    @Query("SELECT c FROM Comuna c WHERE c.nombre LIKE %:nombre%")
    List<Comuna> buscarPorNombre(
            @Param("nombre") String nombre
    );

}