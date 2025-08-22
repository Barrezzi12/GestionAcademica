package com.umg.gestionAcademica.dto;

import java.time.LocalDate;
import java.time.Period;

public class EstudianteDTO {
    private String carnet;
    private String nombreEstudiante;
    private int edad; // En lugar de fecha de nacimiento

    // Constructor
    public EstudianteDTO(String carnet, String nombreEstudiante, LocalDate fechaNacimiento) {
        this.carnet = carnet;
        this.nombreEstudiante = nombreEstudiante;
        this.edad = calcularEdad(fechaNacimiento);
    }

    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Getters y Setters
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}