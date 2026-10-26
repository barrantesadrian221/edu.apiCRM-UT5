package edu.altair.apicrm.repositories;

import edu.altair.apicrm.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findByModulo(String modulo);
}

