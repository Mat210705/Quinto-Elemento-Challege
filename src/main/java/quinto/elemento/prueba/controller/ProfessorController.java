package quinto.elemento.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/crear/profesor",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody ResponseEntity<?> createProfesor(ProfesorDTO profesorDTO){
        return profesorService.createProfesor(profesorDTO);
    }
    @PutMapping(path = "/editar/profesor",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> editarProfesor(@RequestParam int id, ProfesorDTO profesorDTO){
        return profesorService.editarProfesor(id, profesorDTO);
    }
    @DeleteMapping(path = "/eliminar/profesor")
    public ResponseEntity<?> eliminarProfesor(@RequestParam int id){
        return profesorService.eliminarProfesor(id);
    }
    @PostMapping(path = "/profesor/anotarse/curso")
    public ResponseEntity<?> anotarseACurso(@RequestParam int id,@RequestParam String nombre,@RequestParam String turno){
        return profesorService.anotarseACurso(id, nombre, turno);
    }
}



