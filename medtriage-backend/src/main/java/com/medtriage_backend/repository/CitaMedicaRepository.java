package com.medtriage_backend.repository;

import com.medtriage_backend.dto.CitaMedicaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CitaMedicaRepository extends JpaRepository<Long, CitaMedicaDTO> {

    List<CitaMedicaDTO> findByNivelPrioridad(String nivelPrioridad);

    List<CitaMedicaDTO> findAllByOrderByFechaCitaDesc();

}
