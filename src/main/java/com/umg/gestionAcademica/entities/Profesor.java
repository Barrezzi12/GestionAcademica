package com.umg.gestionAcademica.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    private String nombreProfesor;

    private String correoProfesor;
}