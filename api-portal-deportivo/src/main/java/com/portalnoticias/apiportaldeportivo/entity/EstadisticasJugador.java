package com.portalnoticias.apiportaldeportivo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadisticas_jugador")
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadistica;
    private Integer goles;
    private Integer asistencias;
    private Integer partidosJugados;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugadores jugador;

    @ManyToOne
    @JoinColumn(name = "id_temporada")
    private Temporadas temporada;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Ligas liga;

    public Integer getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Integer idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

    public Temporadas getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporadas temporada) {
        this.temporada = temporada;
    }

    public Ligas getLiga() {
        return liga;
    }

    public void setLiga(Ligas liga) {
        this.liga = liga;
    }

    @Override
    public String toString() {
        return "EstadisticasJugador [idEstadistica=" + idEstadistica + ", goles=" + goles + ", asistencias="
                + asistencias + ", partidosJugados=" + partidosJugados + "]";
    }
}
