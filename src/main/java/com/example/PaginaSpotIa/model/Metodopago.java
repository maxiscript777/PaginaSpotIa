package com.example.PaginaSpotIa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metodos_pago")
public class Metodopago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoPago;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50,
            message = "El nombre debe contener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 100,
            message = "La descripción debe contener entre 5 y 100 caracteres")
    private String descripcion;

    @OneToMany(mappedBy = "metodoPago")
    @ToString.Exclude
    @JsonManagedReference
    private List<Reservas> reservas;

}