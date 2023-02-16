package quinto.elemento.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Anotaciones Lombok

@Getter
@Setter
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Curso curso;
    private Turno turno;


    public Profesor() {

    }

    public Profesor(String nombre, String apellido, String email, String password, Curso curso, Turno turno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.curso = curso;
        this.turno = turno;
    }
}
