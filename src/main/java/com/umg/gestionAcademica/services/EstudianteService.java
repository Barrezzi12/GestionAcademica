package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.dto.EstudianteDTO;
import com.umg.gestionAcademica.entities.Estudiante;
import com.umg.gestionAcademica.repositories.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    // Crear estudiante - devuelve DTO
    public EstudianteDTO crearEstudiante(Estudiante estudiante) {
        Estudiante guardado = estudianteRepository.save(estudiante);
        return convertirAEstudianteDTO(guardado);
    }

    // Obtener todos los estudiantes como DTOs
    public List<EstudianteDTO> obtenerTodos() {
        return estudianteRepository.findAll()
                .stream()
                .map(this::convertirAEstudianteDTO)
                .collect(Collectors.toList());
    }

    // Obtener estudiante por carnet como DTO
    public Optional<EstudianteDTO> obtenerPorId(String carnet) {
        return estudianteRepository.findById(carnet)
                .map(this::convertirAEstudianteDTO);
    }

    // Actualizar estudiante y devolver DTO
    public EstudianteDTO actualizarEstudiante(String carnet, Estudiante actualizado) {
        Estudiante estudiante = estudianteRepository.findById(carnet)
                .map(est -> {
                    est.setNombreEstudiante(actualizado.getNombreEstudiante());
                    est.setFechaNacimiento(actualizado.getFechaNacimiento());
                    return estudianteRepository.save(est);
                }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return convertirAEstudianteDTO(estudiante);
    }

    // Eliminar estudiante
    public void eliminarEstudiante(String carnet) {
        estudianteRepository.deleteById(carnet);
    }

    // Método privado para convertir entidad a DTO
    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        return new EstudianteDTO(
                estudiante.getCarnet(),
                estudiante.getNombreEstudiante(),
                estudiante.getFechaNacimiento()
        );
    }

    public List<EstudianteDTO> obtenerEstudiantesPorNombre(String nombre) {
    List<Estudiante> estudiantes;
    if (nombre == null || nombre.isEmpty()) {
        estudiantes = estudianteRepository.findAll();
    } else {
        estudiantes = estudianteRepository.findByNombreEstudianteContainingIgnoreCase(nombre);
    }
    return estudiantes.stream()
            .map(this::convertirAEstudianteDTO)
            .collect(Collectors.toList());
}

}
