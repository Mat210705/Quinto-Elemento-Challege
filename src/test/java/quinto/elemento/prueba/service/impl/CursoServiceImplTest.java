package quinto.elemento.prueba.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.dto.CursoDTO;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.CursoRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CursoServiceImplTest {

    @Autowired
    CursoServiceImpl cursoServiceImpl;
    @Autowired
    CursoRepository cursoRepository;

    @Test
    public void obtenerTodosLosCursos(){
        List<Curso> cursos = cursoServiceImpl.getAllCursos();
        assertThat(cursos).isNotNull();
    }
    @Test
    public void obtenerCursoPorNombre(){
        String nombre = "Java-Inicial";
        Curso curso = cursoServiceImpl.getCursoByName(nombre);
        assertThat(curso).isNotNull();
        assertThat(curso.getNombre()).isEqualTo(nombre);
    }
    @Test
    public void crearCurso(){
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNombre("Javascript Inicial");
        cursoDTO.setTurno("Tarde");
        ResponseEntity<?> cursoCreado = cursoServiceImpl.crearCurso(cursoDTO);
        assertThat(cursoCreado).isNotNull();
    }
    @Test
    public void crearProfesor_DatosVaciosExcepcion(){
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNombre("Javascript Inicial");
        cursoDTO.setTurno("");
        ResponseEntity<?> cursoCreado = cursoServiceImpl.crearCurso(cursoDTO);
        assertThat(cursoCreado).isNotNull();
    }

    @Test
    public void editarProfesor(){
        int id = 1;
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNombre("Java-Inicial");
        cursoDTO.setTurno("Tarde");
        Curso curso = cursoRepository.findById(id);
        curso.setNombre(cursoDTO.getNombre());
        curso.setTurno(cursoDTO.getTurno());
        ResponseEntity<?> cursoCreado = cursoServiceImpl.editarCurso(id, cursoDTO);
        assertThat(cursoCreado).isNotNull();
    }
}
