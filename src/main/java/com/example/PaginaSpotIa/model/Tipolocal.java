package com.example.PaginaSpotIa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "tipos_local")
public class Tipolocal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    @NotBlank(message = "El nombre del tipo de servicio no puede estar en blanco")
    @Size(min = 2, max = 20, message = "El nombre del tipo de servicio debe contener entre 2 y 20 caracteres")
    @Column(nullable = false)
    private String nombreTipo;

    @OneToMany(mappedBy = "tipodelocal")
    @ToString.Exclude
    private List<Local> localesConTipo;
}
