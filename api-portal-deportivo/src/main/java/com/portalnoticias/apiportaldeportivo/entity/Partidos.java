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
@Table(name = "partidos")
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartido;
    private LocalDateTime fechaHora;
    private Integer jornada;
    private String estadio;
    private String estadoPartido;
    private Integer resultadoLocal;
    private Integer resultadoVisitante;
    private Integer idExternoApi;

    @ManyToOne
    @JoinColumn(name = "id_equipo_local")
    private Equipos equipoLocal;

    @ManyToOne
    @JoinColumn(name = "id_equipo_visitante")
    private Equipos equipoVisitante;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Ligas liga;

    @ManyToOne
    @JoinColumn(name = "id_temporada")
    private Temporadas temporada;

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getEstadoPartido() {
        return estadoPartido;
    }

    public void setEstadoPartido(String estadoPartido) {
        this.estadoPartido = estadoPartido;
    }

    public Integer getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(Integer resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public Integer getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(Integer resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public Integer getIdExternoApi() {
        return idExternoApi;
    }

    public void setIdExternoApi(Integer idExternoApi) {
        this.idExternoApi = idExternoApi;
    }

    public Equipos getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipos equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipos getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipos equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Ligas getLiga() {
        return liga;
    }

    public void setLiga(Ligas liga) {
        this.liga = liga;
    }

    public Temporadas getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporadas temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Partidos [idPartido=" + idPartido + ", fechaHora=" + fechaHora + ", jornada=" + jornada + ", estadio="
                + estadio + ", estadoPartido=" + estadoPartido + ", resultadoLocal=" + resultadoLocal
                + ", resultadoVisitante=" + resultadoVisitante + "]";
    }
}
