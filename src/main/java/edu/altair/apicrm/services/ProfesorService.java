package edu.altair.apicrm.services;

import edu.altair.apicrm.dtos.ProfesorResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfesorService {

    @Transactional(readOnly = true)
    List<ProfesorResponseDto> getProfesoresByModulo(String modulo);

    @Transactional(readOnly = true)
    List<ProfesorResponseDto> obtenerTodos();

    @Transactional(readOnly = true)
    List<ProfesorResponseDto> obtenerPorModulo(String nombreModulo);
}