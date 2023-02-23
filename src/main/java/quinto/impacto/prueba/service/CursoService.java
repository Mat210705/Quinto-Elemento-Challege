package quinto.impacto.prueba.service;

import org.springframework.http.ResponseEntity;
import quinto.impacto.prueba.dto.CursoDTO;
import quinto.impacto.prueba.model.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> getAllCursos();

    Curso getCursoByName(String nombre);

    ResponseEntity<?> crearCurso(CursoDTO cursoDTO);

    ResponseEntity<?> editarCurso(int id, CursoDTO cursoDTO);

    ResponseEntity<?> eliminarCurso(int id);



}
