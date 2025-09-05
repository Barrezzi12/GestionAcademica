package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.dto.ReporteCursoProfesorDTO;
import com.umg.gestionAcademica.dto.ReporteEstudianteInscripcionesDTO;
import com.umg.gestionAcademica.dto.ReporteInscripcionDTO;
import com.umg.gestionAcademica.dto.ReporteProfesorCursosDTO;
import com.umg.gestionAcademica.repositories.ReporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }


    public List<ReporteProfesorCursosDTO> generarReporteProfesoresConCursos() {
        return reporteRepository.generarReporteProfesoresConCursos();
    }

    public List<ReporteEstudianteInscripcionesDTO> generarReporteEstudiantesInscritos() {
        return reporteRepository.generarReporteEstudiantesInscritos();
    }

    public List<ReporteCursoProfesorDTO> generarReporteCursosConProfesor() {
        return reporteRepository.generarReporteCursosConProfesor();
    }
}
