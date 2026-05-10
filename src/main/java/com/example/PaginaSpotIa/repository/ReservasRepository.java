package com.example.heroes.heroes.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

    List<Reservas> findByFechaReserva(Date fechaReserva);

    List<Reservas> findByPrecio(Integer precio);

    List<Reservas> findByCantidadPersonas(Integer cantidadPersonas);

}