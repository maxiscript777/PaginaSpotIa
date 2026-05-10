package com.example.heroes.heroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.heroes.heroes.model.Metodopago;
import com.example.heroes.heroes.repository.MetodopagoRepository;

@Service
public class MetodopagoService {

    @Autowired
    private MetodopagoRepository metodopagoRepository;

    public List<Metodopago> obtenerMetodosPago() {
        return metodopagoRepository.findAll();
    }

    public Metodopago obtenerMetodoPagoPorId(Integer id) {
        return metodopagoRepository.findById(id).orElse(null);
    }

    public List<Metodopago> buscarPorNombre(String nombreMetodo) {
        return metodopagoRepository.findByNombreMetodo(nombreMetodo);
    }

    public Metodopago guardarMetodoPago(Metodopago metodopago) {
        return metodopagoRepository.save(metodopago);
    }

    public void eliminarMetodoPago(Integer id) {
        metodopagoRepository.deleteById(id);
    }

}