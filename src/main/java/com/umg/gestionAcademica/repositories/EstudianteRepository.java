package com.umg.gestionAcademica.repositories;

import com.umg.gestionAcademica.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
    List<Estudiante> findByNombreEstudianteContainingIgnoreCase(String nombre);
}
