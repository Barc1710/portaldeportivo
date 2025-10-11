package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.EstadisticasJugador;

public interface IEstadisticasJugadorService {
    List<EstadisticasJugador> buscarTodos();

    void guardar(EstadisticasJugador estadistica);

    void modificar(EstadisticasJugador estadistica);

    Optional<EstadisticasJugador> buscarId(Integer id);

    void eliminar(Integer id);
}
