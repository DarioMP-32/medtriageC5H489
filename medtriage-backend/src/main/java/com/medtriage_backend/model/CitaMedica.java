package com.medtriage_backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "cita_medica")
public class CitaMedica {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigocita", nullable = false, unique = true, length = 30)
    private String codigocita;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pacienteid", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctorid", nullable = false)
    private Doctor doctor;

    @Column(name = "nivelprioridad", nullable = false)
    private String nivelprioridad;

    @Column(name = "motivoconsulta", nullable = false)
    private String motivoconsulta;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "montoconsulta", nullable = false)
    private BigDecimal montoconsulta;

    @Column(name = "fechacita", nullable = false)
    private LocalDateTime fechacita;



    public CitaMedica() {
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
