package com.example.PaginaSpotIa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.PaginaSpotIa.DTO.tipolocalDTO;
import com.example.PaginaSpotIa.model.Tipolocal;
import com.example.PaginaSpotIa.service.TipolocalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tipos-locales")
public class TipolocalController {

    private final TipolocalService service;

    public TipolocalController(TipolocalService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tipolocal>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipolocal> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Tipolocal> guardar(
            @Valid @RequestBody tipolocalDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipolocal> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody tipolocalDTO dto) {

        return ResponseEntity.ok(
                service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}