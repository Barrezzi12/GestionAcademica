package com.umg.gestionAcademica.controller;

import com.umg.gestionAcademica.dto.EstudianteDTO;
import com.umg.gestionAcademica.entities.Estudiante;
import com.umg.gestionAcademica.services.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // Crear estudiante → devuelve DTO
    @PostMapping
    public EstudianteDTO crear(@RequestBody Estudiante estudiante) {
        return estudianteService.crearEstudiante(estudiante);
    }

    // Obtener todos los estudiantes o filtrar por nombre
    @GetMapping
    public List<EstudianteDTO> obtenerTodos(@RequestParam(required = false) String nombre) {
        return estudianteService.obtenerEstudiantesPorNombre(nombre);
    }

    // Obtener estudiante por carnet → devuelve DTO
    @GetMapping("/{carnet}")
    public EstudianteDTO obtenerPorId(@PathVariable String carnet) {
        return estudianteService.obtenerPorId(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    // Actualizar estudiante → devuelve DTO
    @PutMapping("/{carnet}")
    public EstudianteDTO actualizar(@PathVariable String carnet, @RequestBody Estudiante estudiante) {
        return estudianteService.actualizarEstudiante(carnet, estudiante);
    }

    // Eliminar estudiante
    @DeleteMapping("/{carnet}")
    public void eliminar(@PathVariable String carnet) {
        estudianteService.eliminarEstudiante(carnet);
    }
}
