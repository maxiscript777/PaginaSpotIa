package com.example.heroes.heroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.heroes.heroes.model.Comuna;
import com.example.heroes.heroes.repository.ComunaRepository;

@Service
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> obtenerComunas() {
        return comunaRepository.findAll();
    }

    public Comuna obtenerComunaPorId(Integer id) {
        return comunaRepository.findById(id).orElse(null);
    }
    public List<Comuna> buscarPorNombre(String nombre) {
        return comunaRepository.findByNombre(nombre);
    }

    public List<Comuna> buscarSimilares(String nombre) {
        return comunaRepository.findByNombreContaining(nombre);
    }

    public List<Comuna> buscarNombreLargo(Integer cantidad) {
        return comunaRepository.buscarComunasNombreLargo(cantidad);
    }

    public Comuna guardarComuna(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public void eliminarComuna(Integer id) {
        comunaRepository.deleteById(id);
    }

}