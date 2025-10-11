package com.portalnoticias.apiportaldeportivo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registros_actividad")
public class RegistrosActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;
    private String accion;
    private String detalles;
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "RegistrosActividad [idRegistro=" + idRegistro + ", accion=" + accion + ", detalles=" + detalles
                + ", fechaHora=" + fechaHora + "]";
    }
}
