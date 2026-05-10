package com.example.PaginaSpotIa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.model.Estado;
import com.example.PaginaSpotIa.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> obtenerEstados() {
        return estadoRepository.findAll();
    }

    public Estado obtenerEstadoPorId(Integer id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public List<Estado> buscarPorNombre(String nombreEstado) {
        return estadoRepository.findByNombreEstado(nombreEstado);
    }

    public Estado guardarEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void eliminarEstado(Integer id) {
        estadoRepository.deleteById(id);
    }

}