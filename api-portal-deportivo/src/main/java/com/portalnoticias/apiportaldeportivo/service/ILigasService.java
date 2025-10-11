package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Ligas;

public interface ILigasService {
    List<Ligas> buscarTodos();

    void guardar(Ligas liga);

    void modificar(Ligas liga);

    Optional<Ligas> buscarId(Integer id);

    void eliminar(Integer id);
}
