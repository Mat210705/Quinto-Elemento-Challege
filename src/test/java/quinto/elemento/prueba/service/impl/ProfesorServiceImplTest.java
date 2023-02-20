package quinto.elemento.prueba.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.ProfesorRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class ProfesorServiceImplTest {

    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;
    @Autowired
    private ProfesorRepository profesorRepository;
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

    @Test
    public void editarProfesor(){
        int id = 1;
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setNombre("Matias");
            profesorDTO.setApellido("Milich");
            profesorDTO.setEmail("Matias123@gmail.com");
            profesorDTO.setPassword("1234");
        Profesor profesor = profesorRepository.findById(id);
            profesor.setNombre(profesorDTO.getNombre());
            profesor.setApellido(profesorDTO.getApellido());
            profesor.setEmail(profesorDTO.getEmail());
            profesor.setPassword(profesorDTO.getPassword());
        ResponseEntity<?> profesorCreado = profesorServiceImpl.editarProfesor(id, profesorDTO);
        assertThat(profesorCreado).isNotNull();
        assertThat(profesor.getId()).isEqualTo(id);
    }

//    @Test
//    public void eliminarProfesor() {
//        Profesor profesor = new Profesor();
//            profesor.setId(1);
//            profesor.setNombre("Matias");
//            profesor.setApellido("Milich");
//            profesor.setEmail("Mat123@gmail.com");
//            profesor.setPassword("1234");
//        Profesor profesor2 = new Profesor();
//            profesor2.setId(2);
//            profesor2.setNombre("Matias");
//            profesor2.setApellido("Milich");
//            profesor2.setEmail("Mat123@gmail.com");
//            profesor2.setPassword("1234");
//        List<Profesor> books;
//        profesorServiceImpl.eliminarProfesor(profesor.getId());
//        assertThat(profesorRepository.count()).isEqualTo(1);
//    }
}
