package quinto.impacto.prueba.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quinto.impacto.prueba.model.Administrator;
import quinto.impacto.prueba.repository.AdministratorRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AdministratorServiceImplTest {
    @Autowired
    AdministratorRepository administratorRepository;

    @Test
    public void obtenerTodosLosProfesores(){
        List<Administrator> administrators = administratorRepository.findAll();
        assertThat(administrators).isNotNull();
    }
}
