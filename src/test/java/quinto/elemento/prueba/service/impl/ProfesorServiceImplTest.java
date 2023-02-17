package quinto.elemento.prueba.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Profesor;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProfesorServiceImplTest {

    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;

    @Test
    public void obtenerTodosLosProfesores(){
        List<Profesor> profesores = profesorServiceImpl.getAllProfesor();
                assertThat(profesores).isNotNull();
    }
    @Test
    public void obtenerProfesorPorId(){
        String nombre = "Matias";
        Profesor profesor = profesorServiceImpl.getProfesorByName(nombre);
        assertThat(profesor).isNotNull();
        assertThat(profesor.getNombre()).isEqualTo(nombre);
    }
    @Test
    public void crearProfesor(){
        ProfesorDTO profesor = new ProfesorDTO();
            profesor.setNombre("Matias");
            profesor.setApellido("Milich");
            profesor.setEmail("Mat123@gmail.com");
            profesor.setPassword("1234");
        ResponseEntity<?> profesorCreado = profesorServiceImpl.createProfesor(profesor);
        assertThat(profesorCreado).isNotNull();
    }
    @Test
    public void crearProfesor_DatosVaciosExcepcion(){
        ProfesorDTO profesor = new ProfesorDTO();
        profesor.setNombre("");
        profesor.setApellido("Milich");
        profesor.setEmail("Mat123@gmail.com");
        profesor.setPassword("1234");
        ResponseEntity<?> profesorCreado = profesorServiceImpl.createProfesor(profesor);
        assertThat(profesorCreado).isNotNull();
    }
}
