package com.umg.gestionAcademica.dto;

public class ReporteEstudianteInscripcionesDTO {
    private String nombreEstudiante;
    private Long totalInscripciones;

    public ReporteEstudianteInscripcionesDTO(String nombreEstudiante, Long totalInscripciones) {
        this.nombreEstudiante = nombreEstudiante;
        this.totalInscripciones = totalInscripciones;
    }
}