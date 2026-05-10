package com.example.heroes.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    List<Estado> findByNombreEstado(String nombreEstado);
    
    List<Estado> findByNombreEstadoContaining(String nombreEstado);

}