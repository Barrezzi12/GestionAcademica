package com.umg.gestionAcademica.services;

import com.umg.gestionAcademica.dto.CursoDTO;
import com.umg.gestionAcademica.entities.Curso;
import com.umg.gestionAcademica.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Crear curso - devuelve DTO
    public CursoDTO crearCurso(Curso curso) {
        Curso guardado = cursoRepository.save(curso);
        return convertirACursoDTO(guardado);
    }

    // Obtener todos los cursos como DTOs
    public List<CursoDTO> obtenerTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::convertirACursoDTO)
                .collect(Collectors.toList());
    }

    // Obtener curso por id como DTO
    public Optional<CursoDTO> obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .map(this::convertirACursoDTO);
    }

    // Actualizar curso y devolver DTO
    public CursoDTO actualizarCurso(Long id, Curso cursoActualizado) {
        Curso curso = cursoRepository.findById(id)
                .map(c -> {
                    c.setNombreCurso(cursoActualizado.getNombreCurso());
                    c.setRequisitoCurso(cursoActualizado.getRequisitoCurso());
                    c.setCreditosCurso(cursoActualizado.getCreditosCurso());
                    c.setProfesor(cursoActualizado.getProfesor());
                    return cursoRepository.save(c);
                }).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return convertirACursoDTO(curso);
    }

    // Eliminar curso (no devuelve DTO)
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    // Método privado para convertir entidad a DTO
    private CursoDTO convertirACursoDTO(Curso curso) {
        String nombreProfesor = curso.getProfesor() != null ? curso.getProfesor().getNombreProfesor() : null;
        return new CursoDTO(
                curso.getNombreCurso(),
                nombreProfesor,
                curso.getCreditosCurso(),
                curso.getRequisitoCurso()
        );
    }

    public List<CursoDTO> obtenerCursosPorCreditos(Integer creditos) {
    List<Curso> cursos;
    if (creditos == null) {
        cursos = cursoRepository.findAll();
    } else {
        cursos = cursoRepository.findByCreditosCurso(creditos);
    }
    return cursos.stream()
            .map(this::convertirACursoDTO)
            .collect(Collectors.toList());
}

}