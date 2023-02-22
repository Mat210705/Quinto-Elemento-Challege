package quinto.elemento.prueba.service;

import org.springframework.http.ResponseEntity;
import quinto.elemento.prueba.model.RoleName;

public interface LoginService {

    ResponseEntity<?> register (String nombre, String apellido, String email, String password, String roleName);


    ResponseEntity<?> login(String email, String password);
}
