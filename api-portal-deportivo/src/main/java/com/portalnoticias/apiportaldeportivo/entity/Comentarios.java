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
@Table(name = "comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;
    private String textoContenido;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_noticia")
    private Noticias noticia;

    @ManyToOne
    @JoinColumn(name = "id_comentario_padre")
    private Comentarios comentarioPadre;

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public void setTextoContenido(String textoContenido) {
        this.textoContenido = textoContenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Noticias getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticias noticia) {
        this.noticia = noticia;
    }

    public Comentarios getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(Comentarios comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    @Override
    public String toString() {
        return "Comentarios [idComentario=" + idComentario + ", textoContenido=" + textoContenido + ", fechaCreacion="
                + fechaCreacion + "]";
    }
}
