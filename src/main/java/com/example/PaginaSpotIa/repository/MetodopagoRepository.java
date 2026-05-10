package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Metodopago;

public interface MetodopagoRepository
        extends JpaRepository<Metodopago, Integer> {

    List<Metodopago> findByNombre(String nombre);

    @Query("SELECT m FROM Metodopago m WHERE m.nombre LIKE %:nombre%")
    List<Metodopago> buscarPorNombre(
            @Param("nombre") String nombre
    );

}