package quinto.impacto.prueba.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import quinto.impacto.prueba.model.Administrator;
import quinto.impacto.prueba.model.Alumno;
import quinto.impacto.prueba.model.Profesor;
import quinto.impacto.prueba.repository.AdministratorRepository;
import quinto.impacto.prueba.repository.AlumnoRepository;
import quinto.impacto.prueba.repository.ProfesorRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoginServiceImplTest {
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    LoginServiceImpl loginService;

    @Test
    public void registerRoleProfesor(){
        String nombre = "matias";
        String apellido = "milich";
        String email = "mat123@gmail.com";
        int password = 1234;
        String roleName = "profesor";
        ResponseEntity<?> register = loginService.register(nombre, apellido, email, password, roleName);
        assertThat(register).isNotNull();
    }
    @Test
    public void registerRoleAlumno(){
        String nombre = "matias";
        String apellido = "milich";
        String email = "mat123@gmail.com";
        int password = 1234;
        String roleName = "alumno";
        ResponseEntity<?> register = loginService.register(nombre, apellido, email, password, roleName);
        assertThat(register).isNotNull();
    }
    @Test
    public void registerRoleNull(){
        String nombre = "matias";
        String apellido = "milich";
        String email = "mat123@gmail.com";
        int password = 1234;
        String roleName = "";
        ResponseEntity<?> register = loginService.register(nombre, apellido, email, password, roleName);
        assertThat(register).isNotNull();
    }


    @Test
    public void loginAdmin(){
        String email = "admin@gmail.com";
        int password = 1234;
        String roleName = "admin";
        ResponseEntity<?> login = loginService.login(email, password, roleName);
        assertThat(login).isNotNull();
    }
    @Test
    public void loginProfesor(){
        String email = "Mat123@gmail.com";
        int password = 1234;
        String roleName = "profesor";
        ResponseEntity<?> login = loginService.login(email, password, roleName);
        assertThat(login).isNotNull();
    }
    @Test
    public void loginAlumno() {
        String email = "mat456@gmail.com";
        int password = 1234;
        String roleName = "alumno";
        ResponseEntity<?> login = loginService.login(email, password, roleName);
        assertThat(login).isNotNull();
    }
    @Test
    public void loginNull() {
        String email = "mat4566@gmail.com";
        int password = 1234;
        String roleName = "";
        ResponseEntity<?> login = loginService.login(email, password, roleName);
        assertThat(login).isNotNull();
    }

}
