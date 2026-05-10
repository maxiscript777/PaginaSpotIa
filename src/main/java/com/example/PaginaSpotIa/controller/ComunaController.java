package com.example.PaginaSpotIa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.PaginaSpotIa.DTO.comunaDTO;
import com.example.PaginaSpotIa.model.Comuna;
import com.example.PaginaSpotIa.service.ComunaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/comunas")
public class ComunaController {

    private final ComunaService service;

    public ComunaController(ComunaService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Comuna>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Comuna> guardar(
            @Valid @RequestBody comunaDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody comunaDTO dto) {

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