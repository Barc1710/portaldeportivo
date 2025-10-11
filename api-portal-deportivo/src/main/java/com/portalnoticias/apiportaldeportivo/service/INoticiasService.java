package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Noticias;

public interface INoticiasService {
    // CRUD para el API de Noticias

    List<Noticias> buscarTodos();
    // Método para listar todas las noticias

    void guardar(Noticias noticia);
    // Método para guardar noticias

    void modificar(Noticias noticia);
    // Método para modificar noticias

    Optional<Noticias> buscarId(Integer id);
    // Método para listar una noticia

    void eliminar(Integer id);
    // Método para eliminar una noticia
}
