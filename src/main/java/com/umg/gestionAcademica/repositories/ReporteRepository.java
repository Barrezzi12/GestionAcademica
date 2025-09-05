package com.umg.gestionAcademica.repositories;

import com.umg.gestionAcademica.dto.ReporteCursoProfesorDTO;
import com.umg.gestionAcademica.dto.ReporteEstudianteInscripcionesDTO;
import com.umg.gestionAcademica.dto.ReporteInscripcionDTO;
import com.umg.gestionAcademica.dto.ReporteProfesorCursosDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends CrudRepository<Object, Long> {

    @Query("SELECT NEW com.umg.gestionAcademica.dto.ReporteProfesorCursosDTO(" +
            "p.nombreProfesor, COUNT(c)) " +
            "FROM Profesor p " +
            "LEFT JOIN p.cursos c " +
            "GROUP BY p.nombreProfesor")
    List<ReporteProfesorCursosDTO> generarReporteProfesoresConCursos();

    @Query("SELECT NEW com.umg.gestionAcademica.dto.ReporteEstudianteInscripcionesDTO(" +
            "e.nombreEstudiante, COUNT(i)) " +
            "FROM Estudiante e " +
            "LEFT JOIN e.inscripciones i " +
            "GROUP BY e.nombreEstudiante")
    List<ReporteEstudianteInscripcionesDTO> generarReporteEstudiantesInscritos();

    @Query("SELECT NEW com.umg.gestionAcademica.dto.ReporteCursoProfesorDTO(" +
            "c.nombreCurso, p.nombreProfesor) " +
            "FROM Curso c " +
            "JOIN c.profesor p")
    List<ReporteCursoProfesorDTO> generarReporteCursosConProfesor();
}
