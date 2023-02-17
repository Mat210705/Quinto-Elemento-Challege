package quinto.elemento.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quinto.elemento.prueba.dto.ProfesorDTO;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.ProfesorRepository;
import quinto.elemento.prueba.service.ProfesorService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getAllProfesor(){
        return profesorRepository.findAll();
    }

    @Override
    public Profesor getProfesorByName(String nombre) {
        return profesorRepository.findByNombre(nombre);
    }

    @Override
    public ResponseEntity<?> createProfesor(ProfesorDTO profesorDTO) {
            if (profesorDTO.getNombre().isEmpty()|| profesorDTO.getApellido().isEmpty()||profesorDTO.getEmail().isEmpty()|| profesorDTO.getPassword().isEmpty()){
                return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
            }
        Profesor newProfesor = new Profesor();
            newProfesor.setNombre(profesorDTO.getNombre());
            newProfesor.setApellido(profesorDTO.getApellido());
            newProfesor.setEmail(profesorDTO.getEmail());
            newProfesor.setPassword(profesorDTO.getPassword());
        profesorRepository.save(newProfesor);
        return new ResponseEntity<>("El Profesor a sido creado correctamente", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarProfesor(String nombre, String apellido, String email, String password, ProfesorDTO profesorDTO) {
        return null;
    }


}
