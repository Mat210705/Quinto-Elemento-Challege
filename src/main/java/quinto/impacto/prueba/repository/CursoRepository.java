package quinto.impacto.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quinto.impacto.prueba.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Curso findByNombre(String nombre);

    Curso findById(int id);
}
