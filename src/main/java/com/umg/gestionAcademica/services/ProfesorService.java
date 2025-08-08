package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.entities.Profesor;
import com.umg.gestionAcademica.repositories.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public Profesor actualizarProfesor(Long id, Profesor profesorActualizado) {
        return profesorRepository.findById(id).map(profesor -> {
            profesor.setNombreProfesor(profesorActualizado.getNombreProfesor());
            profesor.setCorreoProfesor(profesorActualizado.getCorreoProfesor());
            return profesorRepository.save(profesor);
        }).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
