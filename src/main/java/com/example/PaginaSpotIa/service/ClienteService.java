package com.example.PaginaSpotIa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.model.Cliente;
import com.example.PaginaSpotIa.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorRut(String rut) {
        return clienteRepository.findById(rut).orElse(null);
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
    public Cliente buscarPorCorreo(String correo) {
        return clienteRepository.findByCorreo(correo);
    }

     public List<Cliente> buscarSimilares(String nombre) {
        return clienteRepository.findByNombreContaining(nombre);
    }

    public List<Cliente> buscarNombreLargo(Integer cantidad) {
        return clienteRepository.buscarClientesNombreLargo(cantidad);
    }
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(String rut) {
        clienteRepository.deleteById(rut);
    }

}