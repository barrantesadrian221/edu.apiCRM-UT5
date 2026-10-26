package edu.altair.apicrm.controllers;

import edu.altair.apicrm.dtos.ProfesorResponseDto;
import edu.altair.apicrm.services.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    // Se inyecta la interfaz ProfesorService
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    // GET /api/profesores -> Obtener todos
    @GetMapping
    public ResponseEntity<List<ProfesorResponseDto>> obtenerTodos() {
        List<ProfesorResponseDto> profesores = profesorService.obtenerTodos();
        return ResponseEntity.ok(profesores); // HTTP 200 OK
    }

    // GET /api/profesores/modulo/{nombreModulo}
    @GetMapping("/modulo/{nombreModulo}")
    public ResponseEntity<List<ProfesorResponseDto>> obtenerPorModulo(@PathVariable String nombreModulo) {
        List<ProfesorResponseDto> profesores = profesorService.obtenerPorModulo(nombreModulo);
        return ResponseEntity.ok(profesores); // HTTP 200 OK
    }
}