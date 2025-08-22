package com.umg.gestionAcademica.repositories;

import com.umg.gestionAcademica.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByCreditosCurso(int creditos);
}
