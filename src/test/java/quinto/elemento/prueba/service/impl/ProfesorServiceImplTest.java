package quinto.elemento.prueba.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
