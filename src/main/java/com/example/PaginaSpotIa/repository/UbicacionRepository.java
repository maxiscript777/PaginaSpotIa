package com.example.heroes.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {

    List<Ubicacion> findByCalle(String calle);

}