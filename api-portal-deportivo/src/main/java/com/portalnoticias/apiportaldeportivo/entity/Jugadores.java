package com.portalnoticias.apiportaldeportivo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;
    private String nombreCompleto;
    private String posicion;
    private Integer idExternoApi;

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getIdExternoApi() {
        return idExternoApi;
    }

    public void setIdExternoApi(Integer idExternoApi) {
        this.idExternoApi = idExternoApi;
    }

    @Override
    public String toString() {
        return "Jugadores [idJugador=" + idJugador + ", nombreCompleto=" + nombreCompleto + ", posicion=" + posicion
                + ", idExternoApi=" + idExternoApi + "]";
    }
}
