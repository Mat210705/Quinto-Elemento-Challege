package quinto.impacto.prueba.model;


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
    private int password;

    private String roleName;


    @OneToMany(mappedBy="profesor", fetch= FetchType.EAGER)
    Set<Curso> cursos = new HashSet<>();
    @OneToMany(mappedBy="profesor", fetch= FetchType.EAGER)
    Set<Alumno> alumnos = new HashSet<>();

    public Profesor() {

    }

    public Profesor(String nombre, String apellido, String email, int password, String roleName) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roleName = roleName;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public void addAlumnos(Alumno alumno) {
        alumno.setProfesor(this);
        alumnos.add(alumno);
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }


    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

