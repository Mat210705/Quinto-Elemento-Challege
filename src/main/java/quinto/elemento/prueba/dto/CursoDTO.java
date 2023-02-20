package quinto.elemento.prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import quinto.elemento.prueba.model.Profesor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CursoDTO {

    private Integer id;

    private String nombre;

    private String turno;

    public CursoDTO() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="profesor_id")
    private Profesor profesor;


    public CursoDTO(Integer id, String nombre, String turno) {
        this.id = id;
        this.nombre = nombre;
        this.turno = turno;
    }
    @JsonIgnore
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
