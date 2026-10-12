package com.medtriage_backend.repository;

import com.medtriage_backend.model.CitaMedica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    List<CitaMedica> findByNivelprioridadIgnoreCase(String nivelprioridad);

    List<CitaMedica> findAllByOrderByFechacitaDesc();

    boolean existsByCodigocita(String codigocita);

    boolean existsByDoctor_IdAndFechacitaAndEstadoNot(
            Long doctorId,
            java.time.LocalDateTime fechacita,
            String estado
    );
}