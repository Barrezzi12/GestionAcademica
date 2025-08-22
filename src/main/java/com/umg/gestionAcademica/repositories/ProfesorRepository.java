package com.umg.gestionAcademica.repositories;

import com.umg.gestionAcademica.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findByCorreoProfesorContainingIgnoreCase(String correo);
}
