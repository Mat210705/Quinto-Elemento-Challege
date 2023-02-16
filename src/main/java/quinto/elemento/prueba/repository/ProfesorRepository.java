package quinto.elemento.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quinto.elemento.prueba.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}
