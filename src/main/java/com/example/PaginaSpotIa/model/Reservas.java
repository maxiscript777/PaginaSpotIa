package com.example.PaginaSpotIa.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "La fecha no puede ser nula")
    @FutureOrPresent(message = "La fecha debe ser actual o futura")
    private LocalDate fechaReserva;

    @NotNull(message = "La hora no puede ser nula")
    private LocalTime horaReserva;

    @NotNull(message = "La cantidad de personas no puede ser nula")
    @Min(value = 1, message = "Debe haber al menos una persona")
    private Integer cantidadPersonas;

    @NotNull(message = "El total no puede ser nulo")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "rut_cliente")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_local")
    @JsonIgnore
    private Local local;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    @JsonIgnore
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    @JsonIgnore
    private Metodopago metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    @JsonIgnore
    private Estado estado;

}