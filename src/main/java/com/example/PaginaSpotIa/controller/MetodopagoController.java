package com.example.PaginaSpotIa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.PaginaSpotIa.DTO.metodopagoDTO;
import com.example.PaginaSpotIa.model.Metodopago;
import com.example.PaginaSpotIa.service.MetodopagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/metodos-pago")
public class MetodopagoController {

    private final MetodopagoService service;

    public MetodopagoController(MetodopagoService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Metodopago>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metodopago> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Metodopago> guardar(
            @Valid @RequestBody metodopagoDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metodopago> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody metodopagoDTO dto) {

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