package com.umg.gestionAcademica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.gestionAcademica.entities.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}