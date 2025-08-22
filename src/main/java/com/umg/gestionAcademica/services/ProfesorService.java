package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.dto.ProfesorDTO;
import com.umg.gestionAcademica.entities.Profesor;
import com.umg.gestionAcademica.repositories.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    // Crear profesor - devuelve DTO
    public ProfesorDTO crearProfesor(Profesor profesor) {
        Profesor guardado = profesorRepository.save(profesor);
        return convertirAProfesorDTO(guardado);
    }

    // Obtener todos los profesores como DTOs
    public List<ProfesorDTO> obtenerTodos() {
        return profesorRepository.findAll()
                .stream()
                .map(this::convertirAProfesorDTO)
                .collect(Collectors.toList());
    }

    // Obtener profesor por id como DTO
    public Optional<ProfesorDTO> obtenerPorId(Long id) {
        return profesorRepository.findById(id)
                .map(this::convertirAProfesorDTO);
    }

    // Actualizar profesor y devolver DTO
    public ProfesorDTO actualizarProfesor(Long id, Profesor profesorActualizado) {
        Profesor profesor = profesorRepository.findById(id)
                .map(p -> {
                    p.setNombreProfesor(profesorActualizado.getNombreProfesor());
                    p.setCorreoProfesor(profesorActualizado.getCorreoProfesor());
                    return profesorRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        return convertirAProfesorDTO(profesor);
    }

    // Eliminar profesor
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

    // Método privado para convertir entidad a DTO
    private ProfesorDTO convertirAProfesorDTO(Profesor profesor) {
        return new ProfesorDTO(profesor.getNombreProfesor(), profesor.getCorreoProfesor());
    }
    public List<ProfesorDTO> obtenerProfesoresPorCorreo(String correo) {
    List<Profesor> profesores;
    if (correo == null || correo.isEmpty()) {
        profesores = profesorRepository.findAll();
    } else {
        profesores = profesorRepository.findByCorreoProfesorContainingIgnoreCase(correo);
    }
    return profesores.stream()
            .map(this::convertirAProfesorDTO)
            .collect(Collectors.toList());
}

}