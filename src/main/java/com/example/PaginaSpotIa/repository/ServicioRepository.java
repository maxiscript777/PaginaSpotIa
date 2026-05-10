package com.example.heroes.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByNombreServicio(String nombreServicio);

    List<Servicio> findByCantidadDelServicio(Integer cantidadDelServicio);

}