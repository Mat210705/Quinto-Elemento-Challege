package quinto.elemento.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quinto.elemento.prueba.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
