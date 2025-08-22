package com.umg.gestionAcademica.controller;

import com.umg.gestionAcademica.dto.CursoDTO;
import com.umg.gestionAcademica.entities.Curso;
import com.umg.gestionAcademica.services.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Crear curso → devuelve DTO
    @PostMapping
    public CursoDTO crear(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    // Obtener todos los cursos o filtrar por créditos
    @GetMapping
    public List<CursoDTO> obtenerTodos(@RequestParam(required = false) Integer creditos) {
        return cursoService.obtenerCursosPorCreditos(creditos);
    }

    // Obtener curso por ID → devuelve DTO
    @GetMapping("/{id}")
    public CursoDTO obtenerPorId(@PathVariable Long id) {
        return cursoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    // Actualizar curso → devuelve DTO
    @PutMapping("/{id}")
    public CursoDTO actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    // Eliminar curso
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}
