package com.example.PaginaSpotIa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.model.Servicio;
import com.example.PaginaSpotIa.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicioPorId(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public List<Servicio> buscarPorNombre(String nombreServicio) {
        return servicioRepository.findByNombreServicio(nombreServicio);
    }

    public List<Servicio> buscarPorCantidad(Integer cantidad) {
        return servicioRepository.findByCantidadDelServicio(cantidad);
    }
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }
    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }

}