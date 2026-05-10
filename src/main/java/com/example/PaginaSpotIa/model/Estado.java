package com.example.heroes.heroes.model;

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
@Table(name = "estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;

    @NotBlank(message = "El nombre del estado no puede estar en blanco")
    @Size(min = 9, max = 10, message = "El nombre del estado debe contener entre 9 y 10 caracteres")
    @Column(nullable = false)
    private String nombreEstado;

    @OneToMany(mappedBy = "estado")
    @ToString.Exclude
    private List<Reservas> reservasConEstado;
}
