package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas", schema = "crm",
        uniqueConstraints = @UniqueConstraint(name = "uk_estudiante_asignatura", columnNames = {"id_estudiante", "id_asignatura"}))
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula_estudiante"))
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_asignatura", nullable = false, foreignKey = @ForeignKey(name = "fk_matricula_asignatura"))
    private Asignatura asignatura;

    @Column(name = "fecha_matriculacion", nullable = false)
    private LocalDate fechaMatriculacion;

    @Column(name = "nota_final")
    private Double notaFinal;

    public Matricula() {}

    public Matricula(Estudiante estudiante, Asignatura asignatura, LocalDate fechaMatriculacion, Double notaFinal) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.fechaMatriculacion = fechaMatriculacion;
        this.notaFinal = notaFinal;
    }

    // Getters y Setters
    public Long getIdMatricula() { return idMatricula; }
    public void setIdMatricula(Long idMatricula) { this.idMatricula = idMatricula; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }
    public LocalDate getFechaMatriculacion() { return fechaMatriculacion; }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) { this.fechaMatriculacion = fechaMatriculacion; }
    public Double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(Double notaFinal) { this.notaFinal = notaFinal; }
}