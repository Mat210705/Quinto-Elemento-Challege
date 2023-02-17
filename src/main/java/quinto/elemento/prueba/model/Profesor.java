package quinto.elemento.prueba.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Anotaciones Lombok


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


    @OneToMany(mappedBy="profesor", fetch= FetchType.EAGER)
    Set<Curso> cursos = new HashSet<>();


    public Profesor() {

    }

    public Profesor(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void addCursos(Curso curso) {
        curso.setProfesor(this);
        cursos.add(curso);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}

