package com.medtriage_backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaMedicaDTO {

    private Long id;
    private String codigocita;
    private String nombrePaciente;
    private String nombreDoctor;
    private String nivelprioridad;
    private String motivoconsulta;
    private String estado;
    private BigDecimal montoconsulta;
    private LocalDateTime fechacita;


    public CitaMedicaDTO() {
    }


    public CitaMedicaDTO(Long id, String codigocita, String nombrePaciente, String nombreDoctor, String nivelprioridad,
            String motivoconsulta, String estado, BigDecimal montoconsulta, LocalDateTime fechacita) {
        this.id = id;
        this.codigocita = codigocita;
        this.nombrePaciente = nombrePaciente;
        this.nombreDoctor = nombreDoctor;
        this.nivelprioridad = nivelprioridad;
        this.motivoconsulta = motivoconsulta;
        this.estado = estado;
        this.montoconsulta = montoconsulta;
        this.fechacita = fechacita;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCodigocita() {
        return codigocita;
    }


    public void setCodigocita(String codigocita) {
        this.codigocita = codigocita;
    }


    public String getNombrePaciente() {
        return nombrePaciente;
    }


    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }


    public String getNombreDoctor() {
        return nombreDoctor;
    }


    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }


    public String getNivelprioridad() {
        return nivelprioridad;
    }


    public void setNivelprioridad(String nivelprioridad) {
        this.nivelprioridad = nivelprioridad;
    }


    public String getMotivoconsulta() {
        return motivoconsulta;
    }


    public void setMotivoconsulta(String motivoconsulta) {
        this.motivoconsulta = motivoconsulta;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public BigDecimal getMontoconsulta() {
        return montoconsulta;
    }


    public void setMontoconsulta(BigDecimal montoconsulta) {
        this.montoconsulta = montoconsulta;
    }


    public LocalDateTime getFechacita() {
        return fechacita;
    }


    public void setFechacita(LocalDateTime fechacita) {
        this.fechacita = fechacita;
    }

    

}