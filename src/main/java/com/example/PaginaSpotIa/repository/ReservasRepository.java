package com.example.PaginaSpotIa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PaginaSpotIa.model.Reservas;

public interface ReservasRepository
        extends JpaRepository<Reservas, Integer> {

    List<Reservas> findByFechaReserva(LocalDate fechaReserva);

    @Query("SELECT r FROM Reservas r WHERE r.total >= :total")
    List<Reservas> buscarReservasCostosas(
            @Param("total") Integer total
    );

}