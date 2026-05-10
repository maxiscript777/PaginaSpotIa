package com.example.PaginaSpotIa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 20, message = "El nombre debe contener entre 2 y 20 caracteres")
    @Column(nullable = false)
    private String nombreServicio;

    @NotNull(message = "La cantidad del servicio no puede estar vacio")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    @Size(min = 1, max = 15, message = "La cantidad debe contener entre 1 y 15 numeros")
    @Column(nullable = false)
    private Integer cantidadDelServicio;
}
