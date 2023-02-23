package quinto.impacto.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quinto.impacto.prueba.model.Administrator;
import quinto.impacto.prueba.repository.AdministratorRepository;
import quinto.impacto.prueba.service.AdministratorService;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;
    @Override
    public List<Administrator> getAllAdministrator() {
        return administratorRepository.findAll();
    }
}
