package quinto.elemento.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quinto.elemento.prueba.dto.CursoDTO;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.CursoRepository;
import quinto.elemento.prueba.service.CursoService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoByName(String nombre) {
        return cursoRepository.findByNombre(nombre);
    }

    @Override
    public ResponseEntity<?> crearCurso(CursoDTO cursoDTO) {
        if (cursoDTO.getNombre().isEmpty() || cursoDTO.getTurno().isEmpty()){
            return new ResponseEntity<>("Faltan datos para realizar la operacion", HttpStatus.FORBIDDEN);
        }
        Curso newCurso = new Curso();
            newCurso.setNombre(cursoDTO.getNombre());
            newCurso.setTurno(cursoDTO.getTurno());
        cursoRepository.save(newCurso);

        return new ResponseEntity<>("El Curso a sido creado con exito", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarCurso(int id, CursoDTO cursoDTO) {

        Curso editarCurso = cursoRepository.findById(id);
            editarCurso.setNombre(cursoDTO.getNombre());
            editarCurso.setTurno(cursoDTO.getTurno());
        cursoRepository.save(editarCurso);
        return new ResponseEntity<>("El Curso a sido editado correctamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> eliminarCurso(int id) {
        Curso curso = cursoRepository.findById(id);
        cursoRepository.delete(curso);
        return new ResponseEntity<>("Profesor eliminado correctamente",HttpStatus.OK);
    }
}
