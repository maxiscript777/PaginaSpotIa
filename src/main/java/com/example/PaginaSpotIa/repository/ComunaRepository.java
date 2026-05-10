package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PaginaSpotIa.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

    List<Comuna> findByNombre(String nombre);

    List<Comuna> findByNombreContaining(String nombre);

    @Query("SELECT c FROM Comuna c WHERE LENGTH(c.nombre) >= :cantidad")
    List<Comuna> buscarComunasNombreLargo(@Param("cantidad") Integer cantidad);

}