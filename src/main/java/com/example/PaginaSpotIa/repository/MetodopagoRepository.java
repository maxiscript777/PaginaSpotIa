package com.example.heroes.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroes.heroes.model.Metodopago;

@Repository
public interface MetodopagoRepository extends JpaRepository<Metodopago, Integer> {

    List<Metodopago> findByNombreMetodo(String nombreMetodo);
}