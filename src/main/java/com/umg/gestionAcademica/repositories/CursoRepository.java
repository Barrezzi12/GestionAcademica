package com.umg.gestionAcademica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.gestionAcademica.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}