package com.portalnoticias.apiportaldeportivo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipo;
    private String nombreEquipo;
    private String escudoUrl;
    private Integer idExternoApi;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Ligas liga;

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEscudoUrl() {
        return escudoUrl;
    }

    public void setEscudoUrl(String escudoUrl) {
        this.escudoUrl = escudoUrl;
    }

    public Integer getIdExternoApi() {
        return idExternoApi;
    }

    public void setIdExternoApi(Integer idExternoApi) {
        this.idExternoApi = idExternoApi;
    }

    public Ligas getLiga() {
        return liga;
    }

    public void setLiga(Ligas liga) {
        this.liga = liga;
    }

    @Override
    public String toString() {
        return "Equipos [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", escudoUrl=" + escudoUrl
                + ", idExternoApi=" + idExternoApi + "]";
    }
}
