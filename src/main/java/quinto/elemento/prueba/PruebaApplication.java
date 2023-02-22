package quinto.elemento.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quinto.elemento.prueba.model.*;
import quinto.elemento.prueba.repository.AdministratorRepository;
import quinto.elemento.prueba.repository.AlumnoRepository;
import quinto.elemento.prueba.repository.CursoRepository;
import quinto.elemento.prueba.repository.ProfesorRepository;

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
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
		@Bean
		public CommandLineRunner initData() {
			return (args) -> {

				Administrator administrator = new Administrator("Matias","Milich","Mat210705@gmail.com","1234", "ADMIN");
				administratorRepository.save(administrator);
				Profesor profesor1 = new Profesor("Matias", "Milich", "Mat123@gmail.com", "1234", "PROFESOR");
				profesorRepository.save(profesor1);
				Alumno alumno = new Alumno("Milich", "Matias", "mat456@gmail.com","8976", "ALUMNO");
				alumnoRepository.save(alumno);
				Curso javaInicial = new Curso("Java-Inicial", "tarde");
				profesor1.addCursos(javaInicial);
				cursoRepository.save(javaInicial);
				Curso javascriptInicial = new Curso("Javascript-Inicial", "Noche");
				alumno.addCursos(javascriptInicial);
				cursoRepository.save(javascriptInicial);
				Curso sqlInicial = new Curso("Sql-Inicial", "Noche");
				cursoRepository.save(sqlInicial);
			};
		}
	}


