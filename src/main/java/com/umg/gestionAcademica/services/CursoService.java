package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.entities.Curso;
import com.umg.gestionAcademica.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombreCurso(cursoActualizado.getNombreCurso());
            curso.setRequisitoCurso(cursoActualizado.getRequisitoCurso());
            curso.setCreditosCurso(cursoActualizado.getCreditosCurso());
            curso.setProfesor(cursoActualizado.getProfesor());
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}