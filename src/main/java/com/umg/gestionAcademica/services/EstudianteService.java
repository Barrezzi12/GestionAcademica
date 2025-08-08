package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.entities.Estudiante;
import com.umg.gestionAcademica.repositories.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(String carnet) {
        return estudianteRepository.findById(carnet);
    }

    public Estudiante actualizarEstudiante(String carnet, Estudiante actualizado) {
        return estudianteRepository.findById(carnet).map(est -> {
            est.setNombreEstudiante(actualizado.getNombreEstudiante());
            est.setFechaNacimiento(actualizado.getFechaNacimiento());
            return estudianteRepository.save(est);
        }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public void eliminarEstudiante(String carnet) {
        estudianteRepository.deleteById(carnet);
    }
}