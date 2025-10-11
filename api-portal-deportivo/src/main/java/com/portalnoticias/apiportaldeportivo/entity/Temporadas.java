package com.portalnoticias.apiportaldeportivo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "temporadas")
public class Temporadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTemporada;
    private String nombreTemporada;

    public Integer getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Integer idTemporada) {
        this.idTemporada = idTemporada;
    }

    public String getNombreTemporada() {
        return nombreTemporada;
    }

    public void setNombreTemporada(String nombreTemporada) {
        this.nombreTemporada = nombreTemporada;
    }

    @Override
    public String toString() {
        return "Temporadas [idTemporada=" + idTemporada + ", nombreTemporada=" + nombreTemporada + "]";
    }
}
