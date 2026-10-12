package com.medtriage_backend.dto;

import java.math.BigDecimal;

public class CrearCitaDTO {
    private Long pacienteid;
    private Long doctorid;
    private String motivoconsulta;
    private BigDecimal montoconsulta;
    private String estado;


    public CrearCitaDTO() {
    }


    public CrearCitaDTO(Long pacienteid, Long doctorid, String motivoconsulta, BigDecimal montoconsulta,
            String estado) {
        this.pacienteid = pacienteid;
        this.doctorid = doctorid;
        this.motivoconsulta = motivoconsulta;
        this.montoconsulta = montoconsulta;
        this.estado = estado;
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


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    
}
