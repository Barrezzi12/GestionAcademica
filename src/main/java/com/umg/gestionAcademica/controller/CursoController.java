package com.umg.gestionAcademica.controller;

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

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    @GetMapping
    public List<Curso> obtenerTodos() {
        return cursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Curso obtenerPorId(@PathVariable Long id) {
        return cursoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}