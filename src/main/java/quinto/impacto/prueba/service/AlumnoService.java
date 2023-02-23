package quinto.impacto.prueba.service;

import org.springframework.http.ResponseEntity;
import quinto.impacto.prueba.dto.AlumnoDTO;
import quinto.impacto.prueba.model.Alumno;

import java.util.List;

public interface AlumnoService {


    List<Alumno> getAllAlumno();

    Alumno getAlumnoByName(String nombre);
    Alumno getAlumnoByEmail(String email);
    ResponseEntity<?> createAlumno(AlumnoDTO alumnoDTO);

    ResponseEntity editarAlumno(int id, AlumnoDTO alumnoDTO);

    ResponseEntity eliminarAlumno(int id);

    ResponseEntity<?> anotarseACurso(int id, String nombre, String turno);
}
