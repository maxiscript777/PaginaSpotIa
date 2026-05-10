package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Region;

public interface RegionRepository
        extends JpaRepository<Region, Integer> {

    List<Region> findByNombre(String nombre);
    
    @Query("SELECT r FROM Region r WHERE r.nombre LIKE %:nombre%")
    List<Region> buscarPorNombre(
            @Param("nombre") String nombre
    );

}