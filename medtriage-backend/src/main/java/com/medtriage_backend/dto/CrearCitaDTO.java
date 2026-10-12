package com.medtriage_backend.dto;

import java.math.BigDecimal;

public class CrearCitaDTO {
    private Long pacienteid;
    private Long doctorid;
    private String motivoconsulta;
    private BigDecimal montoconsulta;
    private String nivelPrioridad;


    public CrearCitaDTO() {
    }


    public CrearCitaDTO(Long pacienteid, Long doctorid, String motivoconsulta, BigDecimal montoconsulta,
            String nivelPrioridad) {
        this.pacienteid = pacienteid;
        this.doctorid = doctorid;
        this.motivoconsulta = motivoconsulta;
        this.montoconsulta = montoconsulta;
        this.nivelPrioridad = nivelPrioridad;
    }


    public Long getPacienteid() {
        return pacienteid;
    }


    public void setPacienteid(Long pacienteid) {
        this.pacienteid = pacienteid;
    }


    public Long getDoctorid() {
        return doctorid;
    }


    public void setDoctorid(Long doctorid) {
        this.doctorid = doctorid;
    }


    public String getMotivoconsulta() {
        return motivoconsulta;
    }


    public void setMotivoconsulta(String motivoconsulta) {
        this.motivoconsulta = motivoconsulta;
    }


    public BigDecimal getMontoconsulta() {
        return montoconsulta;
    }


    public void setMontoconsulta(BigDecimal montoconsulta) {
        this.montoconsulta = montoconsulta;
    }


    public String getNivelPrioridad() {
        return nivelPrioridad;
    }


    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }


    
}