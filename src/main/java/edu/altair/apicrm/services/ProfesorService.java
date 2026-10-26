package edu.altair.apicrm.services;

import edu.altair.apicrm.dtos.ProfesorResponseDto;
import edu.altair.apicrm.entities.Profesor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfesorService {
    @Transactional(readOnly = true)
    List<ProfesorResponseDto> getProfesoresByModulo(String modulo);

    List<ProfesorResponseDto> obtenerTodos();


    List<ProfesorResponseDto> obtenerPorModulo(String nombreModulo);
}
