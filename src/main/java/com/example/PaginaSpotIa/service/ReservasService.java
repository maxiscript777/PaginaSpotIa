package com.example.PaginaSpotIa.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.model.Reservas;
import com.example.PaginaSpotIa.repository.ReservasRepository;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> obtenerReservas() {
        return reservasRepository.findAll();
    }

    public Reservas obtenerReservaPorId(Integer id) {
        return reservasRepository.findById(id).orElse(null);
    }

    public List<Reservas> buscarPorFecha(Date fechaReserva) {
        return reservasRepository.findByFechaReserva(fechaReserva);
    }

    public List<Reservas> buscarPorPrecio(Integer precio) {
        return reservasRepository.findByPrecio(precio);
    }

    public List<Reservas> buscarPorCantidadPersonas(Integer cantidadPersonas) {
        return reservasRepository.findByCantidadPersonas(cantidadPersonas);
    }

    public Reservas guardarReserva(Reservas reserva) {
        return reservasRepository.save(reserva);
    }

    public void eliminarReserva(Integer id) {
        reservasRepository.deleteById(id);
    }

}