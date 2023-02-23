package quinto.impacto.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quinto.impacto.prueba.dto.AlumnoDTO;
import quinto.impacto.prueba.model.Alumno;
import quinto.impacto.prueba.service.AlumnoService;


import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping(path = "/alumnos")
    public List<Alumno> getAll(){
        return alumnoService.getAllAlumno();
    }

    
    @GetMapping(path = "alumno{email}")
    public Alumno getAlumnoByEmail (@RequestParam String email){
        return alumnoService.getAlumnoByEmail(email);
    }
    @PostMapping(path = "/crear/alumno",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody ResponseEntity<?> createAlumno(AlumnoDTO alumnoDTO){
        return alumnoService.createAlumno(alumnoDTO);
    }
    @PutMapping(path = "/editar/alumno",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> editarAlumno(@RequestParam int id,AlumnoDTO alumnoDTO){
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
