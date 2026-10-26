package edu.altair.apicrm.repositories;

import edu.altair.apicrm.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculacionRepository extends JpaRepository<Matricula, Long> {

    // Útil para validar que la asignatura tiene al menos 1 matriculado
    long countByAsignaturaIdAsignatura(Long idAsignatura);
}

