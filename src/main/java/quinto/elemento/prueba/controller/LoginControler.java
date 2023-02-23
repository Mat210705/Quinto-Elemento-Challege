package quinto.elemento.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quinto.elemento.prueba.service.LoginService;


@RestController
public class LoginControler {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/api/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(
            @RequestParam String nombre, @RequestParam String apellido,

            @RequestParam String email, @RequestParam int password,

            @RequestParam String roleName){

        return loginService.register(nombre, apellido, email, password,roleName);
    }
    @RequestMapping(path = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password, @RequestParam String roleName){
        return loginService.login(email, password, roleName);
    }

}
