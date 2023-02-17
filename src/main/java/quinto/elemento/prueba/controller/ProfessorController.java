package quinto.elemento.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Profesor;
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

    @GetMapping(path = "profesores{nombre}")
    public Profesor getProfesorByName(@RequestParam String nombre){
        return profesorService.getProfesorByName(nombre);
    }

    @PostMapping(path = "/crear/profesor")
    public ResponseEntity<?> createProfesor(@RequestBody ProfesorDTO profesorDTO){
        return profesorService.createProfesor(profesorDTO);
    }
    @PutMapping(path = "/editar/profesor")
    public ResponseEntity<?> editarProfesor(@RequestParam int id,@RequestBody ProfesorDTO profesorDTO){
        return profesorService.editarProfesor(id, profesorDTO);
    }
}



