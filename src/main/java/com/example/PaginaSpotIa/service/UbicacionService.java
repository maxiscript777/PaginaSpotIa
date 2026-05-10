package com.example.PaginaSpotIa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.model.Ubicacion;
import com.example.PaginaSpotIa.repository.UbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> obtenerUbicaciones() {
        return ubicacionRepository.findAll();
    }

    public Ubicacion obtenerUbicacionPorId(Integer id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    public List<Ubicacion> buscarPorCalle(String calle) {
        return ubicacionRepository.findByCalle(calle);
    }

    public Ubicacion guardarUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public void eliminarUbicacion(Integer id) {
        ubicacionRepository.deleteById(id);
    }

}