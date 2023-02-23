package quinto.impacto.prueba.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<?> register (String nombre, String apellido, String email, int password, String roleName);


    ResponseEntity<?> login(String email, int password, String roleName);
}
