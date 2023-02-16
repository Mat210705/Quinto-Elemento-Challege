package quinto.elemento.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.ProfesorRepository;
import quinto.elemento.prueba.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProfessorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping(path = "/profesores")
    public List<Profesor> getAllProfesor(){
        return profesorService.getAllProfesor();
    }
}
