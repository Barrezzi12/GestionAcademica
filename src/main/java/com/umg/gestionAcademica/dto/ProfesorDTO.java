package com.umg.gestionAcademica.dto;

public class ProfesorDTO {
    private String nombreProfesor;
    private String correoProfesor;

    // Constructor
    public ProfesorDTO(String nombreProfesor, String correoProfesor) {
        this.nombreProfesor = nombreProfesor;
        this.correoProfesor = correoProfesor;
    }

    // Getters y Setters
    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }
}