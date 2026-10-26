package edu.altair.apicrm.services.impl;

import edu.altair.apicrm.dtos.ProfesorResponseDto;
import edu.altair.apicrm.entities.Profesor;
import edu.altair.apicrm.exceptions.ModuloNotFoundException;
import edu.altair.apicrm.repositories.ProfesorRepository;
import edu.altair.apicrm.services.ProfesorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorResponseDto> getProfesoresByModulo(String modulo) {
        List<Profesor> profesores = profesorRepository.findByModulo(modulo);

        if (profesores.isEmpty()) {
            throw new ModuloNotFoundException("No se encontraron profesores para el módulo: " + modulo);
        }

        return profesores.stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorResponseDto> obtenerTodos() {
        return profesorRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorResponseDto> obtenerPorModulo(String nombreModulo) {
        List<Profesor> profesores = profesorRepository.findByModulo(nombreModulo);

        if (profesores.isEmpty()) {
            throw new ModuloNotFoundException("No se encontraron profesores para el módulo: " + nombreModulo);
        }

        return profesores.stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    private ProfesorResponseDto mapToResponseDto(Profesor profesor) {
        return new ProfesorResponseDto(
                profesor.getIdProfesor(),
                profesor.getNombre(),
                profesor.getApellidos(),
                profesor.getModulo()
        );
    }
}