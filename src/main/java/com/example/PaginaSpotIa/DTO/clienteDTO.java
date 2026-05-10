package com.example.PaginaSpotIa.DTO;

import lombok.Data;

@Data
public class clienteDTO {

    private String rut;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String correo;
    private String contraseña;

}