package com.example.heroes.heroes.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class reservasDTO {
    private Integer idReserva;
    private Date fechaCreacion;
    private Date fechaReserva;
    private Integer precio;
    private Integer cantidadPersonas;
}
