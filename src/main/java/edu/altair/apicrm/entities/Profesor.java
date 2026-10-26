package edu.altair.apicrm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores", schema = "crm")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "modulo", nullable = false, length = 100)
    private String modulo;

    // Constructor vacío por defecto (obligatorio para JPA)
    public Profesor() {
    }

    // Constructor con todos los campos
    public Profesor(Long idProfesor, String nombre, String apellidos, String modulo) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.modulo = modulo;
    }

    // Constructor sin ID (útil para cuando creas registros nuevos antes de que la BD genere el ID)
    public Profesor(String nombre, String apellidos, String modulo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.modulo = modulo;
    }

    // Getters y Setters
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
}