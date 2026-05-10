package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Servicio;

public interface ServicioRepository
        extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByNombre(String nombre);

    @Query("SELECT s FROM Servicio s WHERE s.nombre LIKE %:nombre%")
    List<Servicio> buscarPorNombre(
            @Param("nombre") String nombre
    );

}