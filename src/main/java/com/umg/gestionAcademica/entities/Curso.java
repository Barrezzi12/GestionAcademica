package com.umg.gestionAcademica.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    private String nombreCurso;

    private String requisitoCurso;

    private int creditosCurso;

    @ManyToOne
    @JoinColumn(name = "idProfesor", nullable = false)
    private Profesor profesor;
}