package com.umg.gestionAcademica.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.gestionAcademica.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}