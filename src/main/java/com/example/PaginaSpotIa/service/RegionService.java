package com.example.heroes.heroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.heroes.heroes.model.Region;
import com.example.heroes.heroes.repository.RegionRepository;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> obtenerRegiones() {
        return regionRepository.findAll();
    }
    public Region obtenerRegionPorId(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }

    public List<Region> buscarPorNombre(String nombreRegion) {
        return regionRepository.findByNombreRegion(nombreRegion);
    }

    public Region guardarRegion(Region region) {
        return regionRepository.save(region);
    }

    public void eliminarRegion(Integer id) {
        regionRepository.deleteById(id);
    }

}