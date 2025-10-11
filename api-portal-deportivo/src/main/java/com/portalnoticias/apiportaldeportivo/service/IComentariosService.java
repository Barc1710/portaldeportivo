package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Comentarios;

public interface IComentariosService {
    List<Comentarios> buscarTodos();

    void guardar(Comentarios comentario);

    void modificar(Comentarios comentario);

    Optional<Comentarios> buscarId(Integer id);

    void eliminar(Integer id);
}
