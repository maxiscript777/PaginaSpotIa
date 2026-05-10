package com.example.heroes.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByNombre(String nombre);

    Cliente findByCorreo(String correo);

    List<Cliente> findByNombreContaining(String nombre);

    @Query("SELECT c FROM Cliente c WHERE LENGTH(c.nombre) >= :cantidad")
    List<Cliente> buscarClientesNombreLargo(@Param("cantidad") Integer cantidad);

}