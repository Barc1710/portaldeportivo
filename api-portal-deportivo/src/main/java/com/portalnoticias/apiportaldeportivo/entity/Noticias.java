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
@Table(name = "noticias")
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNoticia;
    private String titulo;
    private String slug;
    private String resumen;
    private String contenido;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Usuarios autor;

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Usuarios getAutor() {
        return autor;
    }

    public void setAutor(Usuarios autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Noticias [idNoticia=" + idNoticia + ", titulo=" + titulo + ", slug=" + slug + ", resumen=" + resumen
                + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaPublicacion=" + fechaPublicacion
                + "]";
    }
}
