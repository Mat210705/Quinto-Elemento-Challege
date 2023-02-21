package quinto.elemento.prueba.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import quinto.elemento.prueba.dto.AlumnoDTO;
import quinto.elemento.prueba.model.Alumno;

import java.util.List;

public interface AlumnoService {


    List<Alumno> getAllAlumno();

    Alumno getAlumnoByName(String nombre);

    ResponseEntity<?> createAlumno(AlumnoDTO alumnoDTO);

    ResponseEntity editarAlumno(int id, AlumnoDTO alumnoDTO);

    ResponseEntity eliminarAlumno(int id);

    ResponseEntity<?> anotarseACurso(int id, String nombre, String turno);
}
