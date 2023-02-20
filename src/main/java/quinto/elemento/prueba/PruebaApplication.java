package quinto.elemento.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.repository.CursoRepository;
import quinto.elemento.prueba.repository.ProfesorRepository;

@SpringBootApplication
public class PruebaApplication {
	@Autowired
	private ProfesorRepository profesorRepository;
	@Autowired
	private CursoRepository cursoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
		@Bean
		public CommandLineRunner initData() {
			return (args) -> {


				Profesor profesor1 = new Profesor("Matias", "Milich", "Mat123@gmail.com", "1234");
				profesorRepository.save(profesor1);
				Curso javaInicial = new Curso("Java-Inicial", "tarde");
				profesor1.addCursos(javaInicial);
				cursoRepository.save(javaInicial);
				Curso javascriptInicial = new Curso("Javascript-Inicial", "Noche");
				cursoRepository.save(javascriptInicial);
				Curso sqlInicial = new Curso("Sql-Inicial", "Noche");
				cursoRepository.save(sqlInicial);
			};
		}
	}


