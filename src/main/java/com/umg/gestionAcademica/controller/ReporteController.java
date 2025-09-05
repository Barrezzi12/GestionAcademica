package com.umg.gestionAcademica.controller;

import com.umg.gestionAcademica.dto.ReporteCursoProfesorDTO;
import com.umg.gestionAcademica.dto.ReporteEstudianteInscripcionesDTO;
import com.umg.gestionAcademica.dto.ReporteInscripcionDTO;
import com.umg.gestionAcademica.dto.ReporteProfesorCursosDTO;
import com.umg.gestionAcademica.services.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    // 🔹 Reporte 1: Inscripciones con detalle de estudiante, curso, profesor, semestre y ciclo
    @GetMapping("/inscripciones")
    public List<ReporteInscripcionDTO> obtenerReporteInscripciones() {
        return reporteService.generarReporteInscripciones();
    }

    // 🔹 Reporte 2: Profesores con número de cursos que imparten
    @GetMapping("/profesores-cursos")
    public List<ReporteProfesorCursosDTO> obtenerReporteProfesoresCursos() {
        return reporteService.generarReporteProfesoresConCursos();
    }

    // 🔹 Reporte 3: Estudiantes con cantidad de cursos inscritos
    @GetMapping("/estudiantes-inscripciones")
    public List<ReporteEstudianteInscripcionesDTO> obtenerReporteEstudiantesInscripciones() {
        return reporteService.generarReporteEstudiantesInscritos();
    }

    // 🔹 Reporte 4: Cursos con su profesor asignado
    @GetMapping("/cursos-profesor")
    public List<ReporteCursoProfesorDTO> obtenerReporteCursosProfesor() {
        return reporteService.generarReporteCursosConProfesor();
    }
}
