package quinto.impacto.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quinto.impacto.prueba.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {

    Administrator findByEmail(String email);
}
