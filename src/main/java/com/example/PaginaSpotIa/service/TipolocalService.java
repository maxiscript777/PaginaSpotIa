package com.example.heroes.heroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.heroes.heroes.model.Tipolocal;
import com.example.heroes.heroes.repository.TipolocalRepository;

@Service
public class TipolocalService {
    @Autowired
    private TipolocalRepository tipolocalRepository;

    public List<Tipolocal> obtenerTiposLocal() {
        return tipolocalRepository.findAll();
    }

    public Tipolocal obtenerTipoLocalPorId(Integer id) {
        return tipolocalRepository.findById(id).orElse(null);
    }

    // BUSCAR POR NOMBRE
    public List<Tipolocal> buscarPorNombre(String nombreTipo) {
        return tipolocalRepository.findByNombreTipoLocal(nombreTipo);
    }

    public Tipolocal guardarTipoLocal(Tipolocal tipolocal) {
        return tipolocalRepository.save(tipolocal);
    }

    public void eliminarTipoLocal(Integer id) {
        tipolocalRepository.deleteById(id);
    }
}