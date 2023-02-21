package quinto.elemento.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quinto.elemento.prueba.dto.AlumnoDTO;
import quinto.elemento.prueba.model.Alumno;
import quinto.elemento.prueba.service.AlumnoService;


import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping(path = "/alumnos")
    public List<Alumno> getAllProfesor(){
        return alumnoService.getAllAlumno();
    }

    @GetMapping(path = "alumnos{nombre}")
    public Alumno getAlumnoByName (@RequestParam String nombre){
        return alumnoService.getAlumnoByName(nombre);
    }

    @PostMapping(path = "/crear/alumno")
    public ResponseEntity<?> createAlumno(@RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.createAlumno(alumnoDTO);
    }
    @PutMapping(path = "/editar/alumno")
    public ResponseEntity<?> editarAlumno(@RequestParam int id,@RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.editarAlumno(id, alumnoDTO);
    }
    @DeleteMapping(path = "/eliminar/alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestParam int id){
        return alumnoService.eliminarAlumno(id);
    }
    @PostMapping(path = "/alumno/anotarse/curso")
    public ResponseEntity<?> anotarseACurso(@RequestParam int id,@RequestParam String nombre,@RequestParam String turno){
        return alumnoService.anotarseACurso(id, nombre, turno);
    }
}
