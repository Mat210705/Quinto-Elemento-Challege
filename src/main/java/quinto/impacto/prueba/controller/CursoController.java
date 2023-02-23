package quinto.impacto.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quinto.impacto.prueba.dto.CursoDTO;
import quinto.impacto.prueba.model.Curso;
import quinto.impacto.prueba.service.CursoService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping(path = "/cursos")
    public List<Curso> getAllCursos(){
        return cursoService.getAllCursos();
    }

    @GetMapping(path = "/cursos{nombre}")
    public Curso getCursoByName(@RequestParam String nombre){
        return cursoService.getCursoByName(nombre);
    }

    @PostMapping(path = "/crear/curso",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody ResponseEntity<?> createCurso( CursoDTO cursoDTO){
        return cursoService.crearCurso(cursoDTO);
    }
    @PutMapping(path = "/editar/curso",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody ResponseEntity<?> editarCurso(@RequestParam int id, CursoDTO cursoDTO){
        return cursoService.editarCurso(id, cursoDTO);
    }
    @DeleteMapping(path = "/eliminar/curso")
    public ResponseEntity<?> eliminarCurso(@RequestParam int id){
        return cursoService.eliminarCurso(id);
    }


}
