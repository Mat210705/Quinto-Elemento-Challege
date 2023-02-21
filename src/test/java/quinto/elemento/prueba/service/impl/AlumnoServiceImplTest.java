package quinto.elemento.prueba.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.dto.AlumnoDTO;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Alumno;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.AlumnoRepository;
import quinto.elemento.prueba.repository.CursoRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AlumnoServiceImplTest {

    @Autowired
    private AlumnoServiceImpl alumnoServiceImpl;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void obtenerTodosLosAlumnos(){
        List<Alumno> alumnos= alumnoServiceImpl.getAllAlumno();
        assertThat(alumnos).isNotNull();
    }
    @Test
    public void obtenerAlumnoPorId(){
        String nombre = "Milich";
        Alumno alumno = alumnoServiceImpl.getAlumnoByName(nombre);
        assertThat(alumno).isNotNull();
        assertThat(alumno.getNombre()).isEqualTo(nombre);
    }
    @Test
    public void crearAlumno(){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setNombre("Milich");
        alumnoDTO.setApellido("Matias");
        alumnoDTO.setEmail("mat456@gmail.com");
        alumnoDTO.setPassword("8976");
        ResponseEntity<?> alumnoCreado = alumnoServiceImpl.createAlumno(alumnoDTO);
        assertThat(alumnoCreado).isNotNull();
    }

    @Test
    public void crearAlumno_DatosVaciosExcepcion(){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setNombre("Milich");
        alumnoDTO.setApellido("Matias");
        alumnoDTO.setEmail("mat456@gmail.com");
        alumnoDTO.setPassword("");
        ResponseEntity<?> alumnoCreado = alumnoServiceImpl.createAlumno(alumnoDTO);
        assertThat(alumnoCreado).isNotNull();
    }

    @Test
    public void editarProfesor(){
        int id = 1;
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setNombre("Matias");
        alumnoDTO.setApellido("Milich");
        alumnoDTO.setEmail("Matias123@gmail.com");
        alumnoDTO.setPassword("1234");
        Alumno alumno = alumnoRepository.findById(id);
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellido(alumnoDTO.getApellido());
        alumno.setEmail(alumnoDTO.getEmail());
        alumno.setPassword(alumnoDTO.getPassword());
        ResponseEntity<?> alumnoCreado = alumnoServiceImpl.editarAlumno(id, alumnoDTO);
        assertThat(alumnoCreado).isNotNull();
        assertThat(alumno.getId()).isEqualTo(id);
    }


    @Test
    public void anotarseACurso(){
        int id= 1;
        String nombre= "Sql-Inicial";
        String turno= "Noche";
        Alumno alumno = alumnoRepository.findById(id);
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setTurno(turno);
        alumno.addCursos(curso);
        cursoRepository.save(curso);
        ResponseEntity<?> cursoAnotado = alumnoServiceImpl.anotarseACurso(id,nombre,turno);
        assertThat(cursoAnotado).isNotNull();
    }
}
