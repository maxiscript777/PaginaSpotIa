package com.example.PaginaSpotIa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "locales")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLocal;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50,
            message = "El nombre debe contener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 150,
            message = "La descripción debe contener entre 5 y 150 caracteres")
    private String descripcion;

    @NotNull(message = "La capacidad no puede ser nula")
    @Min(value = 1, message = "La capacidad debe ser mayor a 0")
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_local")
    @JsonBackReference
    private Tipolocal tipoLocal;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion")
    @JsonBackReference
    private Ubicacion ubicacion;

    @OneToMany(mappedBy = "local")
    @ToString.Exclude
    @JsonManagedReference
    private List<Reservas> reservas;

    @ManyToMany
    @JoinTable(name ="local_servicios",
                joinColumns = @JoinColumn(name = "local_id"),
                inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;

}