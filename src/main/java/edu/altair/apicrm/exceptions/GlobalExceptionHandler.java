package edu.altair.apicrm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModuloNotFoundException.class)
    public ProblemDetail manejarModuloNoEncontrado(ModuloNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        problem.setTitle("Módulo No Encontrado");
        problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));

        return problem;
    }
}


