package com.umg.gestionAcademica.dto;


public class CursoDTO {
    private String nombreCurso;
    private String nombreProfesor; // en vez de exponer ID_PROFESOR
    private int creditosCurso;
    private String requisitoCurso;

    // Constructor
    public CursoDTO(String nombreCurso, String nombreProfesor, int creditosCurso, String requisitoCurso) {
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.creditosCurso = creditosCurso;
        this.requisitoCurso = requisitoCurso;
    }

    // Getters y Setters
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getCreditosCurso() {
        return creditosCurso;
    }

    public void setCreditosCurso(int creditosCurso) {
        this.creditosCurso = creditosCurso;
    }

    public String getRequisitoCurso() {
        return requisitoCurso;
    }

    public void setRequisitoCurso(String requisitoCurso) {
        this.requisitoCurso = requisitoCurso;
    }
}