package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Partidos;

public interface IPartidosService {
    List<Partidos> buscarTodos();

    void guardar(Partidos partido);

    void modificar(Partidos partido);

    Optional<Partidos> buscarId(Integer id);

    void eliminar(Integer id);
}
