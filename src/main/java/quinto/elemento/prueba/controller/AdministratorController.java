package quinto.elemento.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quinto.elemento.prueba.model.Administrator;
import quinto.elemento.prueba.model.Alumno;
import quinto.elemento.prueba.service.AdministratorService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @GetMapping(path = "/admins")
    public List<Administrator> getAllAdministrator(){
        return administratorService.getAllAdministrator();
    }
}
