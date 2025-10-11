package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Equipos;

public interface IEquiposService {
    List<Equipos> buscarTodos();

    void guardar(Equipos equipo);

    void modificar(Equipos equipo);

    Optional<Equipos> buscarId(Integer id);

    void eliminar(Integer id);
}
