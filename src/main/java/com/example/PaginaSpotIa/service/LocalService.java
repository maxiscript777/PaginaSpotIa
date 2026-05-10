package com.example.PaginaSpotIa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.model.Local;
import com.example.PaginaSpotIa.repository.LocalRepository;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public List<Local> obtenerLocales() {
        return localRepository.findAll();
    }

    public Local obtenerLocalPorId(Integer id) {
        return localRepository.findById(id).orElse(null);
    }

    public List<Local> buscarPorNombre(String nombreLocal) {
        return localRepository.findByNombreLocal(nombreLocal);
    }

    public Local guardarLocal(Local local) {
        return localRepository.save(local);
    }

    public void eliminarLocal(Integer id) {
        localRepository.deleteById(id);
    }

}