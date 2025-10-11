package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Jugadores;

public interface IJugadoresService {
    List<Jugadores> buscarTodos();

    void guardar(Jugadores jugador);

    void modificar(Jugadores jugador);

    Optional<Jugadores> buscarId(Integer id);

    void eliminar(Integer id);
}
