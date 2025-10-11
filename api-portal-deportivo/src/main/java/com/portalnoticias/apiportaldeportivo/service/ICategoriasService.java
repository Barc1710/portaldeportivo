package com.portalnoticias.apiportaldeportivo.service;

import java.util.List;
import java.util.Optional;

import com.portalnoticias.apiportaldeportivo.entity.Categorias;

public interface ICategoriasService {
    // CRUD para el API de Categorias

    List<Categorias> buscarTodos();
    // Método para listar todas las categorías

    void guardar(Categorias categoria);
    // Método para guardar categorías

    void modificar(Categorias categoria);
    // Método para modificar categorías

    Optional<Categorias> buscarId(Integer id);
    // Método para listar una categoría

    void eliminar(Integer id);
    // Método para eliminar una categoría
}
