package com.example.PaginaSpotIa.model;

import java.util.List;

import jakarta.persistence.Entity;
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
@Table(name = "clientes")
public class Cliente {

    @Id
    @NotBlank(message = "El rut no puede estar en blanco")
    @Size(min = 10, max = 11, message = "El rut debe contener entre 10 y 11 caracteres incluyendo puntos y guión")
    private String rut;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 20, message = "El nombre debe contener entre 2 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "La direccion no puede estar vacia")
    @Size(min = 5, max = 30, message = "La direccion debe contener entre 5 y 30 caracteres")
    private String direccion;

    @NotNull(message = "El telefono no puede estar vacio")
    private Integer telefono;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(min = 10, max = 30, message = "El correo debe contener entre 10 y 30 caracteres")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 5, max = 15, message = "La contraseña debe contener entre 5 y 15 caracteres")
    private String contraseña;

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Reservas> reservasConCliente;

}
