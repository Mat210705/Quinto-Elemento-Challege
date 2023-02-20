package quinto.elemento.prueba.service;

import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.dto.CursoDTO;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;

import java.util.List;

public interface CursoService {

    List<Curso> getAllCursos();

    Curso getCursoByName(String nombre);

    ResponseEntity<?> crearCurso(CursoDTO cursoDTO);

    ResponseEntity<?> editarCurso(int id, CursoDTO cursoDTO);

    ResponseEntity<?> eliminarCurso(int id);



}
