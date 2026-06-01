package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Ubicacion;

public interface UbicacionRepository
        extends JpaRepository<Ubicacion, Integer> {

    @Query("SELECT u FROM Ubicacion u WHERE u.direccion LIKE %:direccion%")
    List<Ubicacion> buscarPorDireccion(
            @Param("direccion") String direccion
    );

}