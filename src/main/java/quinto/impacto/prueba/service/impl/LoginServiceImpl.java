package quinto.impacto.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quinto.impacto.prueba.model.Administrator;
import quinto.impacto.prueba.model.Alumno;
import quinto.impacto.prueba.model.Profesor;
import quinto.impacto.prueba.repository.AdministratorRepository;
import quinto.impacto.prueba.repository.AlumnoRepository;
import quinto.impacto.prueba.repository.ProfesorRepository;
import quinto.impacto.prueba.service.LoginService;

import javax.transaction.Transactional;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AdministratorRepository administratorRepository;





    @Override
    public ResponseEntity<?> register(String nombre, String apellido, String email, int password, String roleName) {
        Profesor registerProfesor = new Profesor(nombre, apellido, email, password, "profesor");
        Alumno registerAlumno = new Alumno(nombre, apellido, email, password, "alumno");
        if (roleName.equals("profesor")){
           profesorRepository.save(registerProfesor);
           return new ResponseEntity<>("Se a registrado correctamente", HttpStatus.ACCEPTED);
        }
        if (roleName.equals("alumno")){
            alumnoRepository.save(registerAlumno);
            return new ResponseEntity<>("Se a registrado correctamente", HttpStatus.ACCEPTED);
        }

       return new ResponseEntity<>("No se a registrado correctamente", HttpStatus.FORBIDDEN);

    }



    @Override
    public ResponseEntity<?> login(String email, int password, String roleName) {
        Profesor profesor = profesorRepository.findByEmail(email);
        Alumno alumno = alumnoRepository.findByEmail(email);
        Administrator administrator = administratorRepository.findByEmail(email);

        if (roleName.equals("profesor")){
            profesorRepository.save(profesor);
            return new ResponseEntity<>("Se a registrado correctamente", HttpStatus.ACCEPTED);
        }
        if (roleName.equals("alumno")){
            alumnoRepository.save(alumno);
            return new ResponseEntity<>("Se a registrado correctamente", HttpStatus.ACCEPTED);
        }
        if (roleName.equals("admin")){
            administratorRepository.save(administrator);
            return new ResponseEntity<>("Se a registrado correctamente", HttpStatus.ACCEPTED);
        }


           return new ResponseEntity<>("Su email y password no pertenecen a una persona registrada", HttpStatus.BAD_REQUEST);

    }

}
