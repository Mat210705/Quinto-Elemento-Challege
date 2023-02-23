package quinto.impacto.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quinto.impacto.prueba.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Alumno findById(int id);
    Alumno findByEmail(String email);
    Alumno findByNombre(String Nombre);
    Alumno findByEmailAndPassword(String email, String password);
}
