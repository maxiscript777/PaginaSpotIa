package com.example.PaginaSpotIa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.PaginaSpotIa.DTO.estadoDTO;
import com.example.PaginaSpotIa.model.Estado;
import com.example.PaginaSpotIa.service.EstadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {

    private final EstadoService service;

    public EstadoController(EstadoService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estado> guardar(
            @Valid @RequestBody estadoDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody estadoDTO dto) {

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