package com.example.waterProyect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "registro_fugas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name = "fecha_fuga")
    private LocalDate fechaFuga;
    @Column(name="inicio_fuga")
    private LocalTime inicio;
    @Column(name="fin_fuga")
    private LocalTime fin;
    @Column(name="Estado")
    private String estado;
}
