package com.umg.gestionAcademica.dto;

public class ReporteProfesorCursosDTO {
    private String nombreProfesor;
    private Long totalCursos;

    public ReporteProfesorCursosDTO(String nombreProfesor, Long totalCursos) {
        this.nombreProfesor = nombreProfesor;
        this.totalCursos = totalCursos;
    }
}
