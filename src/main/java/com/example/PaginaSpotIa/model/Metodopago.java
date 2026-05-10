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
@Table(name = "metodos de pago")
public class Metodopago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodo;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 20, message = "El nombre debe contener entre 4 y 20 caracteres")
    @Column(nullable = false)
    private String nombreMetodo;

    @OneToMany(mappedBy = "metodopago")
    @ToString.Exclude
    private List<Reservas> reservasConMetodopago;
}
