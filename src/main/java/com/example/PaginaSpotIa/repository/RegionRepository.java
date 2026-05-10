package com.example.PaginaSpotIa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaginaSpotIa.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findByNombreRegion(String nombreRegion);
    
}