package quinto.elemento.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quinto.elemento.prueba.model.Administrator;
import quinto.elemento.prueba.model.Alumno;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.AdministratorRepository;
import quinto.elemento.prueba.repository.AlumnoRepository;
import quinto.elemento.prueba.repository.ProfesorRepository;
import quinto.elemento.prueba.service.LoginService;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AdministratorRepository administratorRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;



    @Override
    public ResponseEntity<?> register(String nombre, String apellido, String email, String password, String roleName) {
        Profesor registerProfesor = new Profesor(nombre, apellido, email, password, "PROFESOR");
        Alumno registerAlumno = new Alumno(nombre, apellido, email, password, "ALUMNO");
        if (roleName.equals("PROFESOR")){
            profesorRepository.save(registerProfesor);
        }
        if (roleName.equals("ALUMNO")){
            alumnoRepository.save(registerAlumno);
        }

       return new ResponseEntity<>("Se a registrado correctamente", HttpStatus.ACCEPTED);

    }

    @Override
    public ResponseEntity<?> login(String email, String password){
        Profesor profesor = profesorRepository.findByEmail(email);
        Alumno alumno = alumnoRepository.findByEmail(email);
        Administrator administrator = administratorRepository.findByEmail(email);
        if(email.equals(alumno.getEmail()) && password.equals(alumno.getPassword())){
          return new ResponseEntity<>("Se a registrado Correctamente", HttpStatus.OK);
        }
        if(email.equals(administrator.getEmail()) && password.equals(administrator.getPassword())){
            return new ResponseEntity<>("Se a registrado Correctamente", HttpStatus.OK);
        }
        if(email.equals(profesor.getEmail()) && password.equals(profesor.getPassword())){
            return new ResponseEntity<>("Se a registrado Correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Su email y password no pertenecen a una persona registrada", HttpStatus.BAD_REQUEST);
    }

}
