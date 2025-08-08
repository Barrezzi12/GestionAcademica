package com.umg.gestionAcademica.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Estudiante {

    @Id
    private String carnet;

    private String nombreEstudiante;

    private LocalDate fechaNacimiento;
}