package com.umg.gestionAcademica.controller;

import com.umg.gestionAcademica.dto.ProfesorDTO;
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

    // Crear profesor → devuelve DTO
    @PostMapping
    public ProfesorDTO crear(@RequestBody Profesor profesor) {
        return profesorService.crearProfesor(profesor);
    }

    // Obtener todos los profesores o filtrar por correo
    @GetMapping
    public List<ProfesorDTO> obtenerTodos(@RequestParam(required = false) String correo) {
        return profesorService.obtenerProfesoresPorCorreo(correo);
    }

    // Obtener profesor por ID → devuelve DTO
    @GetMapping("/{id}")
    public ProfesorDTO obtenerPorId(@PathVariable Long id) {
        return profesorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    // Actualizar profesor → devuelve DTO
    @PutMapping("/{id}")
    public ProfesorDTO actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return profesorService.actualizarProfesor(id, profesor);
    }

    // Eliminar profesor
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
    }
}
