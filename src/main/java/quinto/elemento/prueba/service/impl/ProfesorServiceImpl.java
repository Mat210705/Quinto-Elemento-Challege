package quinto.elemento.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.CursoRepository;
import quinto.elemento.prueba.repository.ProfesorRepository;
import quinto.elemento.prueba.service.ProfesorService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    CursoRepository cursoRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<Profesor> getAllProfesor(){
        return profesorRepository.findAll();
    }

    @Override
    public Profesor getProfesorByName(String nombre) {
        return profesorRepository.findByNombre(nombre);
    }

    @Override
    public ResponseEntity<?> createProfesor(ProfesorDTO profesorDTO) {
            if (profesorDTO.getNombre().isEmpty()|| profesorDTO.getApellido().isEmpty()||profesorDTO.getEmail().isEmpty()|| profesorDTO.getPassword().isEmpty()){
                return new ResponseEntity<>("Faltan datos para realizar la operacion", HttpStatus.FORBIDDEN);
            }
        Profesor newProfesor = new Profesor();
            newProfesor.setNombre(profesorDTO.getNombre());
            newProfesor.setApellido(profesorDTO.getApellido());
            newProfesor.setEmail(profesorDTO.getEmail());
            newProfesor.setPassword(profesorDTO.getPassword());
        profesorRepository.save(newProfesor);
        return new ResponseEntity<>("El Profesor a sido creado correctamente", HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<?> editarProfesor(int id, ProfesorDTO profesorDTO) {

        Profesor editProfesor = profesorRepository.findById(id);
            editProfesor.setNombre(profesorDTO.getNombre());
            editProfesor.setApellido(profesorDTO.getApellido());
            editProfesor.setEmail(profesorDTO.getEmail());
            editProfesor.setPassword(profesorDTO.getPassword());
        profesorRepository.save(editProfesor);
        return new ResponseEntity<>("El Profesor a sido editado correctamente", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> eliminarProfesor(int id) {
        Profesor profesor = profesorRepository.findById(id);
        profesorRepository.delete(profesor);
        return new ResponseEntity<>("Profesor eliminado correctamente",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> anotarseACurso(int id, String nombre, String turno){
       Profesor profesor = profesorRepository.findById(id);
       Curso curso = new Curso();
       curso.setNombre(nombre);
       curso.setTurno(turno);
       profesor.addCursos(curso);
       cursoRepository.save(curso);
       return new ResponseEntity<>("Se a anotado al curso Correctamente", HttpStatus.OK);

    }

//
}
