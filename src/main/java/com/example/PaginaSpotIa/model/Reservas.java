package com.example.PaginaSpotIa.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha de creacion de la reserva no puede ser pasada")
    @Column(nullable = false)
    private Date fechaCreacion;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha de reserva no puede ser pasada")
    @Column(nullable = false)
    private Date fechaReserva;

    @NotNull(message = "El precio no puede estar vacio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    @Size(min = 1, max = 15, message = "El precio debe contener entre 1 y 15 numeros")
    @Column(nullable = false)
    private Integer precio;

    @NotNull(message = "La cantidad de personas que asisten no puede estar vacia")
    @Min(value = 1, message = "La cantidad de personas debe ser mayor a 0")
    @Size(min = 1, max = 8, message = "El numero de la cantidad de personas debe tener entre 1 y 8 numeros")
    @Column(nullable = false)
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "metodopago_id")
    private Metodopago metodopago;
    
}
