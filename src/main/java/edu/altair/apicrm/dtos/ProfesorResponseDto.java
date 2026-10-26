package edu.altair.apicrm.dtos;



public record ProfesorResponseDto(
        Long idProfesor,
        String nombre,
        String apellidos,
        String modulo

) {}