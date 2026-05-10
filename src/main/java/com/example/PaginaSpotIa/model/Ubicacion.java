package com.example.PaginaSpotIa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ubicaciones")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUbicacion;

    @NotBlank(message = "La calle no puede estar en blanco")
    @Size(min = 2, max = 20, message = "El nombre de la calle debe contener entre 2 y 20 caracteres")
    @Column(nullable = false)
    private String calle;

    @NotNull(message = "El numero no puede estar vacio")
    @Column(nullable = false)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "comuna_id")
    private Comuna comuna;

    @OneToMany(mappedBy = "ubicacion")
    @ToString.Exclude
    private List<Local> locales;
}
