package com.medtriage_backend.service;

import com.medtriage_backend.dto.CitaMedicaDTO;
import com.medtriage_backend.dto.CrearCitaDTO;
import com.medtriage_backend.model.CitaMedica;
import com.medtriage_backend.model.Doctor;
import com.medtriage_backend.model.Paciente;
import com.medtriage_backend.repository.CitaMedicaRepository;
import com.medtriage_backend.repository.DoctorRepository;
import com.medtriage_backend.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public CitaMedicaService(
            CitaMedicaRepository citaMedicaRepository,
            DoctorRepository doctorRepository,
            PacienteRepository pacienteRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional(readOnly = true)
    public List<CitaMedicaDTO> obtenerTodas() {
        return citaMedicaRepository.findAllByOrderByFechacitaDesc()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<CitaMedicaDTO> obtenerPorPrioridad(String prioridad) {
        return citaMedicaRepository.findByNivelprioridadIgnoreCase(prioridad)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    @Transactional
    public CitaMedicaDTO crearCita(CrearCitaDTO dto) {
        if (dto.getPacienteid() == null || dto.getDoctorid() == null) {
            throw new IllegalArgumentException("El paciente y el doctor son obligatorios");
        }

        Doctor doctor = doctorRepository.findById(dto.getDoctorid())
                .orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteid())
                .orElseThrow(() -> new EntityNotFoundException("Paciente no encontrado"));

        LocalDateTime fechaCita = LocalDateTime.now();

        boolean doctorOcupado = citaMedicaRepository
                .existsByDoctor_IdAndFechacitaAndEstadoNot(
                        doctor.getId(),
                        fechaCita,
                        "CANCELADA"
                );

        if (doctorOcupado) {
            throw new IllegalStateException("El doctor no está disponible");
        }

        CitaMedica cita = new CitaMedica();
        cita.setCodigocita(generarCodigoCita());
        cita.setPaciente(paciente);
        cita.setDoctor(doctor);
        cita.setNivelprioridad(dto.getNivelPrioridad());
        cita.setMotivoconsulta(dto.getMotivoconsulta());
        cita.setMontoconsulta(dto.getMontoconsulta());
        cita.setFechacita(fechaCita);
        cita.setEstado("PENDIENTE");

        return convertirADTO(citaMedicaRepository.save(cita));
    }

    @Transactional
    public CitaMedicaDTO actualizarEstado(Long id, String nuevoEstado) {
        CitaMedica cita = citaMedicaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cita médica no encontrada"));

        if (nuevoEstado == null || nuevoEstado.isBlank()) {
            throw new IllegalArgumentException("El estado es obligatorio");
        }

        String estado = nuevoEstado.trim().toUpperCase();

        if (!List.of("EN_ATENCION", "ATENDIDA", "CANCELADA").contains(estado)) {
            throw new IllegalArgumentException("El estado indicado no es válido");
        }

        cita.setEstado(estado);

        return convertirADTO(citaMedicaRepository.save(cita));
    }

    private String generarCodigoCita() {
        String codigo;

        do {
            String identificador = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 4)
                    .toUpperCase();

            codigo = "CIT-" + Year.now().getValue() + "-" + identificador;
        } while (citaMedicaRepository.existsByCodigocita(codigo));

        return codigo;
    }

    private CitaMedicaDTO convertirADTO(CitaMedica cita) {
        CitaMedicaDTO dto = new CitaMedicaDTO();

        dto.setId(cita.getId());
        dto.setCodigocita(cita.getCodigocita());
        dto.setNombrePaciente(cita.getPaciente().getNombrecompleto());
        dto.setNombreDoctor(cita.getDoctor().getNombre());
        dto.setNivelprioridad(cita.getNivelprioridad());
        dto.setMotivoconsulta(cita.getMotivoconsulta());
        dto.setEstado(cita.getEstado());
        dto.setMontoconsulta(cita.getMontoconsulta());
        dto.setFechacita(cita.getFechacita());

        return dto;
    }
}