package quinto.elemento.prueba.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String roleName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy="alumno", fetch= FetchType.EAGER)
    Set<Curso> cursos = new HashSet<>();
    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String email, String password, String roleName) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roleName = roleName;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void addCursos(Curso curso) {
        curso.setAlumno(this);
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}
