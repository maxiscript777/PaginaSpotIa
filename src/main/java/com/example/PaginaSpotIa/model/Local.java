package com.example.heroes.heroes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "locales")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocal;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 20, message = "El nombre debe contener entre 4 y 20 caracteres")
    @Column(nullable = false)
    private String nombreLocal;

    @NotNull(message = "La capacidad del local no puede estar vacía")
    @Column(nullable = false)
    private Integer capacidadLocal;

    @NotNull(message = "El telefono no puede estar vacio")
    @Size(min = 9, max = 11, message = "El telefono debe contener entre 9 y 11 numeros")
    @Column(nullable = false)
    private Integer telefonoLocal;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

    @ManyToOne
    @JoinColumn(name = "tipolocal_id")
    private Tipolocal tipolocal;
}
