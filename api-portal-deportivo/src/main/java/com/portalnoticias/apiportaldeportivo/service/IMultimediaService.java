package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Multimedia;

public interface IMultimediaService {
    List<Multimedia> buscarTodos();

    void guardar(Multimedia multimedia);

    void modificar(Multimedia multimedia);

    Optional<Multimedia> buscarId(Integer id);

    void eliminar(Integer id);
}
