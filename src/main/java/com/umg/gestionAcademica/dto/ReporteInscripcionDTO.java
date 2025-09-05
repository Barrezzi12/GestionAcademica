package com.umg.gestionAcademica.dto;

public class ReporteInscripcionDTO {
    private String estudiante;
    private String curso;
    private String profesor;
    private String semestre;
    private String ciclo;

    public ReporteInscripcionDTO(String estudiante, String curso, String profesor, String semestre, String ciclo) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.profesor = profesor;
        this.semestre = semestre;
        this.ciclo = ciclo;
    }
}