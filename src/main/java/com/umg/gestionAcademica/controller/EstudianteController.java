package com.umg.gestionAcademica.controller;

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

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return estudianteService.crearEstudiante(estudiante);
    }

    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return estudianteService.obtenerTodos();
    }

    @GetMapping("/{carnet}")
    public Estudiante obtenerPorId(@PathVariable String carnet) {
        return estudianteService.obtenerPorId(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @PutMapping("/{carnet}")
    public Estudiante actualizar(@PathVariable String carnet, @RequestBody Estudiante estudiante) {
        return estudianteService.actualizarEstudiante(carnet, estudiante);
    }

    @DeleteMapping("/{carnet}")
    public void eliminar(@PathVariable String carnet) {
        estudianteService.eliminarEstudiante(carnet);
    }
}