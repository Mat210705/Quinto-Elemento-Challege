package quinto.impacto.prueba.service;

import org.springframework.http.ResponseEntity;
import quinto.impacto.prueba.dto.ProfesorDTO;
import quinto.impacto.prueba.model.Profesor;

import java.util.List;

public interface ProfesorService {

    List<Profesor> getAllProfesor();

    Profesor getProfesorByName(String nombre);



    ResponseEntity<?> createProfesor(ProfesorDTO profesorDTO);

    ResponseEntity editarProfesor(int id, ProfesorDTO profesorDTO);

    ResponseEntity eliminarProfesor(int id);

    ResponseEntity<?> anotarseACurso(int id, String nombre, String turno);


}
