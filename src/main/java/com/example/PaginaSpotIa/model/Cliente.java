package com.example.PaginaSpotIa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "clientes")
public class Cliente {

    @Id
    @NotBlank(message = "El rut no puede estar vacío")
    @Size(min = 10, max = 11,
            message = "El rut debe contener entre 10 y 11 caracteres")
    private String rut;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50,
            message = "El nombre debe contener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(min = 5, max = 100,
            message = "La dirección debe contener entre 5 y 100 caracteres")
    private String direccion;

    @NotNull(message = "El teléfono no puede ser nulo")
    private Integer telefono;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(min = 10, max = 100,
            message = "El correo debe contener entre 10 y 100 caracteres")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 5, max = 20,
            message = "La contraseña debe contener entre 5 y 20 caracteres")
    private String contraseña;

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    @JsonIgnore
    private List<Reservas> reservas;

}