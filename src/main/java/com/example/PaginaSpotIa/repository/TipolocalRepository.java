package com.example.PaginaSpotIa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaginaSpotIa.model.Tipolocal;

@Repository
public interface TipolocalRepository extends JpaRepository<Tipolocal, Integer> {

    List<Tipolocal> findByNombreTipoLocal(String nombreTipoLocal);
}


