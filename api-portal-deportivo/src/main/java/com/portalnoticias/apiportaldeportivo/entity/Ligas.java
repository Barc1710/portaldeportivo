package com.portalnoticias.apiportaldeportivo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ligas")
public class Ligas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLiga;
    private String nombreLiga;
    private String pais;
    private Integer idExternoApi;

    public Integer getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(Integer idLiga) {
        this.idLiga = idLiga;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdExternoApi() {
        return idExternoApi;
    }

    public void setIdExternoApi(Integer idExternoApi) {
        this.idExternoApi = idExternoApi;
    }

    @Override
    public String toString() {
        return "Ligas [idLiga=" + idLiga + ", nombreLiga=" + nombreLiga + ", pais=" + pais + ", idExternoApi="
                + idExternoApi + "]";
    }
}
