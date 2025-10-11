package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Temporadas;

public interface ITemporadasService {
    List<Temporadas> buscarTodos();

    void guardar(Temporadas temporada);

    void modificar(Temporadas temporada);

    Optional<Temporadas> buscarId(Integer id);

    void eliminar(Integer id);
}
