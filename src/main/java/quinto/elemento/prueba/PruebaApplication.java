package quinto.elemento.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quinto.elemento.prueba.model.Curso;
import quinto.elemento.prueba.model.Profesor;
import quinto.elemento.prueba.model.Turno;
import quinto.elemento.prueba.repository.ProfesorRepository;

@SpringBootApplication
public class PruebaApplication {
	@Autowired
	private ProfesorRepository profesorRepository;

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
		@Bean
		public CommandLineRunner initData() {
			return (args) -> {
				Profesor profesor = new Profesor("Matias", "Milich", "Mat123@gmail.com", "1234", Curso.JavaInicial, Turno.Tarde);
				profesorRepository.save(profesor);

			};
		}
	}


