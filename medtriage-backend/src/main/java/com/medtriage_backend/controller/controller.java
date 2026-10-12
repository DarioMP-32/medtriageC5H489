package com.medtriage_backend.controller;

import com.medtriage_backend.dto.CitaMedicaDTO;
import com.medtriage_backend.dto.CrearCitaDTO;
import com.medtriage_backend.service.CitaMedicaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class controller {

    private final CitaMedicaService citaMedicaService;

    public controller(CitaMedicaService citaMedicaService) {
        this.citaMedicaService = citaMedicaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaMedicaDTO>> obtenerTodas() {
        return ResponseEntity.ok(citaMedicaService.obtenerTodas());
    }

    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<CitaMedicaDTO>> obtenerPorPrioridad(
            @PathVariable String prioridad) {
        return ResponseEntity.ok(citaMedicaService.obtenerPorPrioridad(prioridad));
    }

    @PostMapping
    public ResponseEntity<CitaMedicaDTO> crearCita(
            @RequestBody CrearCitaDTO dto) {
        CitaMedicaDTO citaCreada = citaMedicaService.crearCita(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaCreada);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<CitaMedicaDTO> actualizarEstado(
            @PathVariable Long id,
            @RequestBody EstadoCitaDTO dto) {
        CitaMedicaDTO citaActualizada = citaMedicaService.actualizarEstado(
                id,
                dto.getEstado()
        );
        return ResponseEntity.ok(citaActualizada);
    }

    public static class EstadoCitaDTO {

        private String estado;

        public EstadoCitaDTO() {
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }
}