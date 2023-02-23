package quinto.impacto.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quinto.impacto.prueba.dto.AlumnoDTO;
import quinto.impacto.prueba.model.Alumno;
import quinto.impacto.prueba.model.Curso;
import quinto.impacto.prueba.repository.AlumnoRepository;
import quinto.impacto.prueba.repository.CursoRepository;
import quinto.impacto.prueba.service.AlumnoService;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class AlumnoServiceImpl implements AlumnoService {



    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Alumno> getAllAlumno() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getAlumnoByName(String nombre) {
        return alumnoRepository.findByNombre(nombre);
    }

    @Override
    public Alumno getAlumnoByEmail(String email) {
        return alumnoRepository.findByEmail(email);
    }

    @Override
    public ResponseEntity<?> createAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO.getNombre().isEmpty()|| alumnoDTO.getApellido().isEmpty()||alumnoDTO.getEmail().isEmpty()){
            return new ResponseEntity<>("Faltan datos para realizar la operacion", HttpStatus.FORBIDDEN);
        }
        Alumno newAlumno = new Alumno();
        newAlumno.setNombre(alumnoDTO.getNombre());
        newAlumno.setApellido(alumnoDTO.getApellido());
        newAlumno.setEmail(alumnoDTO.getEmail());
        newAlumno.setPassword(alumnoDTO.getPassword());
        alumnoRepository.save(newAlumno);
        return new ResponseEntity<>("El Alumno a sido creado correctamente", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity editarAlumno(int id, AlumnoDTO alumnoDTO) {

        Alumno editAlumno = alumnoRepository.findById(id);
        editAlumno.setNombre(alumnoDTO.getNombre());
        editAlumno.setApellido(alumnoDTO.getApellido());
        editAlumno.setEmail(alumnoDTO.getEmail());
        editAlumno.setPassword(alumnoDTO.getPassword());
        alumnoRepository.save(editAlumno);
        return new ResponseEntity<>("El Alumno a sido editado correctamente", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity eliminarAlumno(int id) {

        Alumno editAlumno = alumnoRepository.findById(id);
        alumnoRepository.delete(editAlumno);
        return new ResponseEntity<>("El alumno a sido eliminado exitosamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> anotarseACurso(int id, String nombre, String turno) {
        Alumno alumno = alumnoRepository.findById(id);
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setTurno(turno);
        alumno.addCursos(curso);
        cursoRepository.save(curso);
        return new ResponseEntity<>("Se a anotado al curso correctamente", HttpStatus.OK);
    }
}
