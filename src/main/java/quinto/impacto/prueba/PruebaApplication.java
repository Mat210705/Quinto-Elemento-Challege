package quinto.impacto.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quinto.impacto.prueba.model.Administrator;
import quinto.impacto.prueba.model.Alumno;
import quinto.impacto.prueba.model.Curso;
import quinto.impacto.prueba.model.Profesor;
import quinto.impacto.prueba.repository.AdministratorRepository;
import quinto.impacto.prueba.repository.AlumnoRepository;
import quinto.impacto.prueba.repository.CursoRepository;
import quinto.impacto.prueba.repository.ProfesorRepository;

@SpringBootApplication
public class PruebaApplication {
	@Autowired
	private ProfesorRepository profesorRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AdministratorRepository administratorRepository;


	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
		@Bean
		public CommandLineRunner commandLineRunner(ProfesorRepository profesorRepository, CursoRepository cursoRepository, AlumnoRepository alumnoRepository, AdministratorRepository administratorRepository ) {
			return (args) -> {

				Administrator administrator1 = new Administrator("MatiasAdmin", "MilichAdmin","admin@gmail.com", "1234", "admin");
				administratorRepository.save(administrator1);
				Profesor profesor1 = new Profesor("Matias", "Milich", "Mat123@gmail.com", 1234,  "profesor");
				profesorRepository.save(profesor1);
				Alumno alumno = new Alumno("Milich", "Matias", "mat456@gmail.com",1234, "alumno");
				alumnoRepository.save(alumno);
				Curso javaInicial = new Curso("Java-Inicial", "tarde");
				profesor1.addCursos(javaInicial);
				profesor1.addAlumnos(alumno);
				cursoRepository.save(javaInicial);
				Curso javascriptInicial = new Curso("Javascript-Inicial", "Noche");
				alumno.addCursos(javascriptInicial);
				cursoRepository.save(javascriptInicial);
				Curso sqlInicial = new Curso("Sql-Inicial", "Noche");
				cursoRepository.save(sqlInicial);

			};
		}
	}


