package com.umg.gestionAcademica.controller;

import com.umg.gestionAcademica.entities.Profesor;
import com.umg.gestionAcademica.services.ProfesorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return profesorService.crearProfesor(profesor);
    }

    @GetMapping
    public List<Profesor> obtenerTodos() {
        return profesorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Profesor obtenerPorId(@PathVariable Long id) {
        return profesorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return profesorService.actualizarProfesor(id, profesor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
    }
}