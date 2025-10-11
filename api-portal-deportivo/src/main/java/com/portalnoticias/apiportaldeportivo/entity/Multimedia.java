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
@Table(name = "multimedia")
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMultimedia;
    private String urlArchivo;
    private String tipoArchivo;
    private String pieDeFoto;
    private LocalDateTime fechaSubida;

    @ManyToOne
    @JoinColumn(name = "id_usuario_subida")
    private Usuarios usuarioSubida;

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getPieDeFoto() {
        return pieDeFoto;
    }

    public void setPieDeFoto(String pieDeFoto) {
        this.pieDeFoto = pieDeFoto;
    }

    public LocalDateTime getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDateTime fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Usuarios getUsuarioSubida() {
        return usuarioSubida;
    }

    public void setUsuarioSubida(Usuarios usuarioSubida) {
        this.usuarioSubida = usuarioSubida;
    }

    @Override
    public String toString() {
        return "Multimedia [idMultimedia=" + idMultimedia + ", urlArchivo=" + urlArchivo + ", tipoArchivo="
                + tipoArchivo + ", pieDeFoto=" + pieDeFoto + ", fechaSubida=" + fechaSubida + "]";
    }
}
