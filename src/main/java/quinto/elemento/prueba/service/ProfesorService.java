package quinto.elemento.prueba.service;

import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Profesor;

import java.util.List;

public interface ProfesorService {

    List<Profesor> getAllProfesor();

    Profesor getProfesorByName(String nombre);



    ResponseEntity<?> createProfesor(ProfesorDTO profesorDTO);

    ResponseEntity editarProfesor(int id, ProfesorDTO profesorDTO);

    ResponseEntity eliminarProfesor(int id);

    ResponseEntity<?> anotarseACurso(int id, String nombre, String turno);


}
