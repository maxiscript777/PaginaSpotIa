package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Cliente;

public interface ClienteRepository
        extends JpaRepository<Cliente, String> {

    List<Cliente> findByNombre(String nombre);

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE %:nombre%")
    List<Cliente> buscarPorNombre(
            @Param("nombre") String nombre
    );

}